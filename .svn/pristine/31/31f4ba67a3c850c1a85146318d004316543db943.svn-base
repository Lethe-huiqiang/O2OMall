package com.jixie.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionServlet;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class CommonHelper extends BaseAction{
	/**
	 * 该方法专门用于请求特定页面
	 */
	public String askPages(){
		String page=ServletActionContext.getRequest().getParameter("page");
		return page;
	}
	
	/**
	 * @category 获取RequestScope范围内的map
	 */
	public static Map<String,Object> requestMap(){
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> request = (Map<String, Object>) ctx.get("request");
		return request;
	}
	
	/**
	 * @category 获取request
	 */
	public static HttpServletRequest doRequest(){
		return ServletActionContext.getRequest();
	}
	
	/**
	 * @category 获取前台提交的参数
	 */
	public static String doParameter(String key){
		return doRequest().getParameter(key);
	}
}
