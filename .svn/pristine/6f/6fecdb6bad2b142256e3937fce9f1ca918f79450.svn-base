package com.jixie.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.jixie.action.users.UsersHelper;
import com.jixie.bean.Users;
import com.jixie.utils.Utils;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class MemberAction extends BaseAction{

	private Users users;
	
	/**
	 * 跳转到登录界面
	 * 
	 * @author zhihua 2014.3.13
	 * @return 
	 */
	public String loginUI(){
		return LOGIN;
	}
	
	/**
	 * 该方法用于登录。
	 * 
	 * 	登录账号字段：mail
	 * 	登录密码字段：password
	 * 
	 * @author zhihua 2014.3.12
	 * @return
	 */
	public String login(){
		
		if(users != null){
			
			String loginName = users.getEmail(); // 用户用于登陆的邮箱
			String password = Utils.md5(users.getPassword()); // 用户用于登陆的密码，经过加密
			
			String hql = "FROM Member m WHERE m.mail=? and m.password=?";
			
			List<Users> list = commonService.findListByHQL(hql, new Object[]{loginName, password});
			
			if( list.size() != 0 ){ // 验证成功
				
				Users loginUsers = list.get(0);
				
				// 获取用户类型
				int uType = loginUsers.getUType();
				
				UsersHelper.cleanUsersFromSession();
				// 将登陆成功的用户放到Session中
//				UserHelper.setUsersToSession(loginMember);
				
				// 判断用户类型
				if( uType == 0 ){ 		// 返回会员用户界面
					return "usersUI";
					
				} else if(uType == 1){	// 计协成员
					return "memberUI";
					
				} else {					// 管理员界面
					return "adminUI";
				}
			} else { 						// 验证失败，返回登陆界面
				ActionContext.getContext().put("loginMessage", "用户名和密码不匹配,请重新输入");
				return LOGIN;
			}
		} else {
			return LOGIN;
		}
		
	}
	

	public Users getMember() {
		return users;
	}

	public void setMember(Users users) {
		this.users = users;
	}
}
