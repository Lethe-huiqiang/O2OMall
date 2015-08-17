package com.jixie.service.order;

import java.util.List;
import java.util.Map;

import com.jixie.bean.Commodity;
import com.jixie.bean.EasyUIPageModel;
import com.jixie.bean.Order;

public interface OrderManageService {

	 /**
	  * @return orderList
	  * 
	  */
	  public List displayOrderList(EasyUIPageModel pageModel);
	  
		/**
		 * 获取订单表总记录数
		 */
		public int orderCount();
		
		
	public List  findOrderItemList(String orderId);
		
}
