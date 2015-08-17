package com.jixie.service.impl.order;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gzbugu.common.commonService.BaseService;
import com.jixie.bean.Commodity;
import com.jixie.bean.FileSource;
import com.jixie.bean.Order;
import com.jixie.bean.OrderItem;
import com.jixie.bean.OrderListForm;
import com.jixie.bean.Users;
import com.jixie.service.order.OrderService;
import com.jixie.system.thread.Utils;
import com.jixie.utils.MallManageUtil;



public class OrderServiceImpl extends BaseService implements OrderService {

	
	public void saveOrder(Order order) {
		//生成订单
		commonDao.saveOrUpdate(order);
		//2.生成订单项/扣除商品数量
		for(OrderItem item : order.getList()){
			commonDao.save(item);
//			String addsql="insert  into orderitem values(?,?,?,null)";
//			commonDao.executeNativeSQL(addsql,item.getCommodityId(),item.getOrderId(),item.getBuynum());		
			String sql="update commodity  set INVENTORY=INVENTORY-? where ID=?";
			commonDao.executeNativeSQL(sql,  item.getBuynum(),item.getId());//.executeHQL(sql, orderItem.getBuynum(),orderItem.getId().getCommodityId());
			}

	}
   /**
    *查看订单 
    * 
    */


	
	public List<OrderListForm> showMyOrder(String userId,String searchKey) {
		try{
		List<OrderListForm> olfList = new ArrayList<OrderListForm>();
		//根据用户id查询这个id用户的所有订单
		StringBuffer hql=new StringBuffer("from Order o where o.usersId=?");
		if(MallManageUtil.isNotEmpty(searchKey)){
			if(searchKey.equals("state")){
				hql.append(" and o.state=0 order by updateTime desc");
			}else if(searchKey.equals("inmonth")){			 
				 hql.append(" and TO_DAYS(NOW()) - TO_DAYS(updateTime) <= 30 order by updateTime desc");
			}else if(searchKey.equals("monthago")){
				 hql.append(" and TO_DAYS(NOW()) - TO_DAYS(updateTime) > 30 order by updateTime desc");
			}else if(searchKey.equals("nocomment")){
				hql.append(" and o.comment=null order by updateTime desc");
			}
		}else{
			hql.append(" order by updateTime desc");
		}
		List<Order> list = commonDao.findListByHQL(hql.toString(),userId);
		//遍历订单 生成orderListForm对象,存入List中
		for(Order order : list){
	//--设置订单信息
			OrderListForm olf = new OrderListForm();	
			//--设置订单号
			  olf.setId(order.getId());
			//--设置下单时间
			  olf.setOrdertime(order.getCreateTime());
			//--设置联系方式
			  olf.setPhone(order.getUsersPhone());
			//--设置用收货地址
			  olf.setReceiverinfo(order.getReceiverInfo());
			//--设置用支付状态
			  olf.setPaystate(order.getState().toString());
			//--设置用订单金额
			  olf.setMoney(order.getPrice());
			//--设置用户名
			Users user= commonDao.findById(userId, new Users());
			olf.setUsername(user.getNickname());
		     //--设置商品信息
			//----查询当前订单所有订单项
//			String itemsql = "select * from orderitem where ORDER_ID = ?";
//			List<OrderItem> itemList =(List<OrderItem>)commonDao.findListByNativeSQL(itemsql, order.getId());
			String itemhql="from OrderItem o where o.orderId= ? ";
			List<OrderItem> itemList =commonDao.findListByHQL(itemhql,order.getId()); //orderDao.findOrderItems(order.getId());
			//----遍历所有订单项,获取商品id,查找对应的商品,存入list
			Map<Commodity,Integer> orderCommodityMap = new HashMap<Commodity,Integer>();
			for(OrderItem item : itemList){
				String commodityId = item.getCommodityId();
				Commodity commodity=commonDao.findById(commodityId, new Commodity());
				FileSource fileSource = commonDao.findById(commodity.getPicId(), new FileSource());
				commodity.setFileSource(fileSource);
				orderCommodityMap.put(commodity, item.getBuynum());
			}
			olf.setOrderCommodityMap(orderCommodityMap);
			
			olfList.add(olf);
		}
		return olfList;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
		
	
}
