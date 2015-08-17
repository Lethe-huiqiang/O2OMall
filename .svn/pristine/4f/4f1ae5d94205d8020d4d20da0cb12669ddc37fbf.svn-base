package com.jixie.action.mall;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.jixie.action.BaseAction;
import com.jixie.bean.Commodity;
import com.jixie.bean.EasyUIPageModel;
import com.jixie.bean.Order;
import com.jixie.service.order.OrderManageService;
import com.jixie.utils.MallManageUtil;

public class OrderManageAction extends BaseAction {

	private OrderManageService orderManageService;
	
	public void displayOrderList(){
			Order order=new Order();
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String page=request.getParameter("page");//页码
			String rows=request.getParameter("rows");//每页记录数
										
			EasyUIPageModel pageModel=new EasyUIPageModel(Integer.parseInt(page),Integer.parseInt(rows));
			JSONArray jsonArray = null;
			try {
				JSONObject result=new JSONObject();
				int total=orderManageService.orderCount();//总记录数
				//转换成json数组
				jsonArray = MallManageUtil.formatListToJsonArray(orderManageService.displayOrderList(pageModel));
				result.put("rows", jsonArray);
				result.put("total", total);
				MallManageUtil.write(response, result);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		  }
	/**
	 * @return orderItemList
	 * 
	 */
    public void orderItemList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String orderId=request.getParameter("orderId");//订单号
		
		List commodityList=orderManageService.findOrderItemList(orderId);
    	request.setAttribute("commodityList", commodityList);
    	JSONArray jsonArray = null;
		try {
			JSONObject result=new JSONObject();
			//转换成json数组
			jsonArray = MallManageUtil.formatListToJsonArray(commodityList);
			result.put("rows", jsonArray);
			MallManageUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    //修改订单状态
    public void changeOrderState(){
    	HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		
		String orderId=request.getParameter("id");//订单号
		int updateState=Integer.parseInt(request.getParameter("state"))+1;//更新订单状态
    	
		String hql="update Order o set o.state=? where o.id=?";
		boolean result=commonService.executeHQL(hql,updateState, orderId);
		if(result){
			try {
				this.sendMsgAjax("{\"check\":true}", "utf-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
    
    
	public OrderManageService getOrderManageService() {
		return orderManageService;
	}

	public void setOrderManageService(OrderManageService orderManageService) {
		this.orderManageService = orderManageService;
	}
	
  }
