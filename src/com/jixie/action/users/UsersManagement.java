package com.jixie.action.users;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.jixie.action.BaseAction;
import com.jixie.action.UploadHelper;
import com.jixie.bean.Commodity;
import com.jixie.bean.EasyUIPageModel;
import com.jixie.bean.FileSource;
import com.jixie.bean.Users;
import com.jixie.utils.MallManageUtil;
import com.jixie.utils.Utils;
import com.opensymphony.xwork2.ActionContext;

public class UsersManagement extends BaseAction{

	private String usersId;

	public String listUsers(){
		
		String hql = "from Users users  order by users.creTime";
		List<Users> list = commonService.findListByHQL(hql);
		//ActionContext.getContext().getContextMap().put("usersList", list);
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> request = (Map<String, Object>) ctx.get("request");
		request.put("usersList", list);
		return "usersList";
	}
	
	//会员管理列表
	public void manageUsersList(){
		
//		String hql = "from Users users where users.status <> 1 order by users.creTime";
//		List<Users> list = commonService.findListByHQL(hql);
//		//ActionContext.getContext().getContextMap().put("usersList", list);
//		ActionContext ctx = ActionContext.getContext();
//		Map<String, Object> request = (Map<String, Object>) ctx.get("request");
//		request.put("usersList", list);
//		return "manageUsersList";
		
		
		Users users=new Users();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String page=request.getParameter("page");//页码
		String rows=request.getParameter("rows");//每页记录数
		String searchName=request.getParameter("searchname");//搜索key
		if(searchName==null){
			searchName="";
		}
		users.setNickname(searchName);
		EasyUIPageModel pageModel=new EasyUIPageModel(Integer.parseInt(page),Integer.parseInt(rows));
		JSONArray jsonArray = null;
		
		StringBuffer sql=new StringBuffer("from Users u");
		if(MallManageUtil.isNotEmpty(users.getNickname())){
			 sql.append(" and u.nickname like '%"+users.getNickname()+"%'");
		}
		
		try {
			JSONObject result=new JSONObject();
			int total=usersCount(users);//总记录数
			//转换成json数组
			jsonArray = MallManageUtil.formatListToJsonArray(commonService.findLimiteListByHQL(sql.toString().replaceFirst("and", "where"),pageModel.getStart()+1, pageModel.getRows()));
			result.put("rows", jsonArray);
			result.put("total", total);
			MallManageUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取用户表总记录数
	 */
	public  int usersCount(Users users){
		StringBuffer sql=new StringBuffer("select count(*) as total from users");
		if(MallManageUtil.isNotEmpty(users.getNickname())){
			 sql.append(" and nickname like '%"+users.getNickname()+"%'");
		}
		Object result= commonService.entityNativeSQL(sql.toString().replaceFirst("and", "where"));
		int total=Integer.parseInt(result.toString());
		return total;
	}
	
	
	//会员拉黑
	public void limitingUsers() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String ids=request.getParameter("ids");//要删除的商品ID字符串
		String delnums=request.getParameter("delnums");//前台选中要删除的商品个数
		String[] Ids=ids.split(",");//转换为数组
		System.out.println(ids);
		for(int i=0;i<Ids.length;i++){		
			Users users=commonService.findById(Ids[i], new Users());
			users.setStatus(1);
			commonService.saveOrUpdate(users);
		}
		JSONObject result=new JSONObject();
		result.put("success", "true");
		result.put("deltotal", delnums);	
				
		MallManageUtil.write(response, result);
//		Users users = commonService.findById(usersId, new Users());
//		users.setStatus(1);
//		try{
//			commonService.saveOrUpdate(users);
//			this.sendMsgAjax("success", "utf-8");
//		}catch(Exception e){
//			e.printStackTrace();
//			try {
//				this.sendMsgAjax("fail", "utf-8");
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//		}
	}

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}


}
