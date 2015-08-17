package com.jixie.action.mall;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.jixie.action.BaseAction;
import com.jixie.action.users.UsersHelper;
import com.jixie.bean.Commodity;
import com.jixie.bean.EasyUIPageModel;
import com.jixie.bean.Users;
import com.jixie.service.commodityManage.CommodityManageService;
import com.jixie.utils.MallManageUtil;
import com.jixie.utils.Utils;

public class CommodityManageAction extends BaseAction {

	 
	private Users users;
	private CommodityManageService commodityManageService;
	
	public void displayCommodityList(){
		Commodity commodity=new Commodity();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String page=request.getParameter("page");//页码
		String rows=request.getParameter("rows");//每页记录数
		String searchName=request.getParameter("searchname");//搜索key
		if(searchName==null){
			searchName="";
		}
		commodity.setName(searchName);
		EasyUIPageModel pageModel=new EasyUIPageModel(Integer.parseInt(page),Integer.parseInt(rows));
		JSONArray jsonArray = null;
		try {
			JSONObject result=new JSONObject();
			int total=commodityManageService.commodityCount(commodity);//总记录数
			//转换成json数组
			jsonArray = MallManageUtil.formatListToJsonArray(commodityManageService.displayCommodityList(pageModel,commodity));
			result.put("rows", jsonArray);
			result.put("total", total);
			MallManageUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * @param delCommodityIds
	 * 删除商品
	 */
	public void delectCommodity(){
		Commodity commodity=new Commodity();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String ids=request.getParameter("ids");//要删除的商品ID字符串
		String delnums=request.getParameter("delnums");//前台选中要删除的商品个数
		String[] Ids=ids.split(",");//转换为数组
		System.out.println(ids);
		//EasyUIPageModel pageModel=new EasyUIPageModel(Integer.parseInt(page),Integer.parseInt(rows));
		try {
			JSONObject result=new JSONObject();
			commodityManageService.deleteCommodity(Ids,null);//删除商品	
			//if(deltotal>0){
				result.put("success", "true");
				result.put("deltotal", delnums);	
				//}else{}			
				//result.put("errorMsg", "删除失败!");		
			MallManageUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 商城后台系统登录
	 * @throws IOException 
	 */
	public void commodityManageLogin() throws IOException{
		String loginEmail = users.getEmail(); // 用户用于登陆的邮箱
		String password = Utils.md5(users.getPassword()); // 用户用于登陆的密码，经过加密
		
		String hql = "FROM Users u WHERE u.email=? and u.password=? and UType!=0 and auth=1";
		
		try{
		List<Users> list = commonService.findListByHQL(hql,  new Object[]{loginEmail, password});
		
		if(list.size()>0){
			Users users=list.get(0);
			UsersHelper.setUsersToSession(users);
			this.sendMsgAjax("success", "utf-8");
			}
		else{
			this.sendMsgAjax("false", "utf-8");
		}
		}catch(Exception e){
			e.printStackTrace();
			this.sendMsgAjax("error", "utf-8");
		}			
		
	}
	
	public CommodityManageService getCommodityManageService() {
		return commodityManageService;
	}


	public void setCommodityManageService(
			CommodityManageService commodityManageService) {
		this.commodityManageService = commodityManageService;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
}
