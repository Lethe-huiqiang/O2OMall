package com.jixie.service.impl.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gzbugu.common.commonService.BaseService;
import com.jixie.bean.Commodity;
import com.jixie.bean.EasyUIPageModel;
import com.jixie.bean.FileSource;
import com.jixie.bean.Order;
import com.jixie.bean.OrderItem;
import com.jixie.service.order.OrderManageService;
import com.jixie.service.order.OrderService;
import com.jixie.utils.MallManageUtil;

public class OrderManageServiceImpl extends BaseService implements OrderManageService {

	 /**
	  *  查询订单记录
	  *  @return orderList
	  */
	
	public List displayOrderList(EasyUIPageModel pageModel) {
		StringBuffer sql=new StringBuffer("from Order o order by o.state asc");
		
	   return commonDao.findLimiteListByHQL(sql.toString().replaceFirst("and", "where"),pageModel.getStart()+1, pageModel.getRows());
		}
		

	/**
	 * @return 获取订单表总记录数
	 */
	
	public int orderCount() {
//		StringBuffer sql=new StringBuffer("select count(*) as total from order");		
//		Object result= commonDao.entityNativeSQL(sql.toString().replaceFirst("and", "where"));
//		int total=Integer.parseInt(result.toString());
//		return total;
		String hql="select count(*) from Order o";
		int total=Integer.parseInt(commonDao.entityHQL(hql).toString());
		return total;
	}


	
	public List findOrderItemList(String orderId) {
		//根据用户订单ID查询这个订单用户的所有订单明细项
		String hql="from OrderItem o where o.orderId=?";
		List<OrderItem> itemList = commonDao.findListByHQL(hql,orderId);
		//----遍历所有订单项,获取商品id,查找对应的商品,存入list
		List<Commodity> orderCommodityList =new ArrayList<Commodity>();
		for(OrderItem item : itemList){
			String commodityId = item.getCommodityId();
			Commodity commodity=commonDao.findById(commodityId, new Commodity());
			commodity.setBuynum(item.getBuynum());
			FileSource fileSource = commonDao.findById(commodity.getPicId(), new FileSource());
			commodity.setFileSource(fileSource);
			orderCommodityList.add(commodity);
		}
		return orderCommodityList;
	}

}
