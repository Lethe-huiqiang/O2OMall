package com.jixie.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.gzbugu.common.commonService.ICommonService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {

	public ICommonService commonService;
	
	
	/**
	 * 把list转换为json数组
	 * @param list 对象
	 */
	@SuppressWarnings("unchecked")
	public String changeListToStr(List list) {
		if (list.equals(null) || null == list) {
			return null;
		} else {
			JSONArray json = JSONArray.fromObject(list);
			return json.toString();
		}
	}

	/**
	 * 使用ajax发送text数据
	 * 
	 * @param content
	 * @throws IOException
	 */
	public void sendMsgAjax(String content, String code) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		if (code == null) {
			response.setCharacterEncoding("UTF-8");
		} else {
			response.setCharacterEncoding("" + code + "");
		}
		response.getWriter().write(content);
		response.setContentType("text/html");
		response.getWriter().close();
	}

	/**
	 * 使用ajax发送text数据
	 * 
	 * @param content
	 * @param type
	 * @throws IOException
	 */
	public void sendTypeMsgAjax(String content, String code, String type)
			throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		if (code == null) {
			response.setCharacterEncoding("UTF-8");
		} else {
			response.setCharacterEncoding("" + code + "");
		}

		if ("text".equals(type)) {
			response.setContentType("text/html");
		} else if ("json".equals(type)) {
			response.setContentType("application/json");
		}
		response.getWriter().write(content);
		response.getWriter().close();
	}
	
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	
	public ICommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(ICommonService commonService) {
		this.commonService = commonService;
	}

}
