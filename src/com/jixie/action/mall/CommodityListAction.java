package com.jixie.action.mall;

import com.jixie.action.BaseAction;

public class CommodityListAction extends BaseAction {

	
	public String test(String ID){
		System.out.println(ID);
		return ID;
	}
	/*
	 //===============将商品回显到商城首页===================
	 String sql="select * from commodity where id=?";
	  List<Commodity> list=commodityService.findCommodityByID(commodity, sql);
	  
	  //将查询到的所有商品信息存入request域带到页面显示
	  request.setAttribute("list", list);
	  try {
		request.getRequestDispatcher("/frontStage/JixieMall/index.jsp").forward(request, response);
	} catch (Exception e) {
		
		e.printStackTrace();
	} 
	*/
}
