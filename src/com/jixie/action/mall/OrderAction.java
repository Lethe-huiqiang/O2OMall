package com.jixie.action.mall;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.jixie.action.BaseAction;

import com.jixie.bean.Commodity;
import com.jixie.bean.Favorite;
import com.jixie.bean.FileSource;
import com.jixie.bean.Order;
import com.jixie.bean.OrderItem;
import com.jixie.bean.OrderListForm;
import com.jixie.bean.ShoppingCart;
import com.jixie.bean.Users;
import com.jixie.bean.UsersInfo;
import com.jixie.service.order.OrderService;
import com.jixie.service.shoppingcart.ShoppingCartService;
import com.jixie.system.thread.Utils;

public class OrderAction extends BaseAction {
	private Commodity commodity; // 商品实体
	private Order order ; //订单实体
	private OrderItem orderItem ; //订单实体
	private File[] commodityPicture;// 上传的图片
	private String[] commodityPictureFileName;// 上传的图片的文件名
	private OrderService orderService;
	private ShoppingCartService shoppingCartService;
	
	/**
	 *生成订单 
	 * @throws Exception 
	 * 
	 */
	public String createOrder() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		if(order.getReceiver().equals("")|order.getReceiverInfo().equals("")|order.getUsersPhone().equals("")){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.sendRedirect(request.getHeader("referer"));
			return null;
		}else{
		
		Timestamp creTime = Utils.date2Stamp(new Date());
			
		order.setCreateTime(creTime);
		order.setUpdateTime(creTime);
		//===============将订单信息存入order bean中=================
		//订单编号
		 order.setId(Utils.getUUID());		 
		 //支付状态
		 order.setState(0);
		    
			
			
		//--金额/将订单项信息存入order中
			Map<Commodity,Integer> cartmap = (Map<Commodity, Integer>) request.getSession().getAttribute("cartmap");
			float money = 0;
			List <OrderItem> list = new ArrayList<OrderItem>();
			for(Map.Entry<Commodity, Integer> entry : cartmap.entrySet()){
				money += entry.getKey().getPrice() * entry.getValue();						
				OrderItem item=new OrderItem();
				item.setOrderId(order.getId());															
				item.setCommodityId(entry.getKey().getId());	
				item.setId(Utils.getUUID());
				item.setBuynum(entry.getValue());
				item.setScore(null);
				list.add(item);
			}
			order.setPrice(money);
			order.setList(list);
			//--用户编号
			Users user = (Users) request.getSession().getAttribute("users");
			String userId=user.getId();
			order.setUsersId(userId);
						
			//调用service 中添加订单的方法
			try{
			 orderService.saveOrder(order);//保存订单
			
			//清空购物车
		      boolean result=shoppingCartService.deleteAllShoppingCart(userId);
		      if(result==true){
		    	  cartmap.clear();
		      }
			}catch (Exception e) {
				e.printStackTrace();
				}
		
		return "createOrder" ;
		}
	}
	/**
	 *显示用户全部订单 
	 * 
	 */
    public String showMyOrder(){
    	 HttpServletRequest request = ServletActionContext.getRequest();
    	 //查找条件
    	String searchKey=request.getParameter("searchKey");//搜索key
    	String orderTitle="";
 		if(searchKey==null){
 			searchKey="";
 		}else if(searchKey.equals("inmonth")){
 			orderTitle="最近一个月";
 		}else if(searchKey.equals("monthago")){
 			orderTitle="一个月之前";
 		}
    	//获取用户ID
		 Users user = (Users) request.getSession().getAttribute("users");
		 String userId=user.getId();
		 //用户头像
		 UsersInfo userinfo=commonService.findById(userId, new UsersInfo());
		 if(userinfo!=null){
			 FileSource userPhoto=commonService.findById(userinfo.getPictureId(), new FileSource());
			//调用Service中根据用户id查询用户具有的订单的方法
			 List<OrderListForm> orderlist = orderService.showMyOrder(userId,searchKey);
			//根据userid查询订单表
	//		 String hql="from Order o where o.usersId = ? ";
	//		 List<Order> list = commonService.findListByHQL(hql, userId);
	//		 List<Commodity> commodityList=new ArrayList<Commodity>();
	//		 if(list.size()>0){
	//			 for (int i = 0; i < list.size(); i++) {
	//				 order=list.get(i);
	//				 List<OrderItem> orderItemList=order.getList();
	//				 for (int j = 0; j < orderItemList.size(); i++) {
	//					 orderItem=orderItemList.get(j);
	//					 String commodityId=orderItem.getId().getCommodityId();
	//					 commodity=commonService.findById(commodityId, new Commodity());
	//					 FileSource fileSource = commonService.findById(commodity.getPicId(), new FileSource());
	//					 commodity.setFileSource(fileSource);
	//					 commodityList.add(j, commodity);
	//				 }
	//				
	//			 }
	//			}
			 request.setAttribute("orderlist", orderlist);
			 request.setAttribute("userPhoto", userPhoto);
			 request.setAttribute("orderTitle", orderTitle);
		 }
    	return "showMyOrder" ;
    }


	public OrderService getOrderService() {
		return orderService;
	}


	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	

	public OrderItem getOrderItem() {
		return orderItem;
	}



	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}



	public File[] getCommodityPicture() {
		return commodityPicture;
	}

	public void setCommodityPicture(File[] commodityPicture) {
		this.commodityPicture = commodityPicture;
	}

	public String[] getCommodityPictureFileName() {
		return commodityPictureFileName;
	}

	public void setCommodityPictureFileName(String[] commodityPictureFileName) {
		this.commodityPictureFileName = commodityPictureFileName;
	}
	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}
	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	
}
