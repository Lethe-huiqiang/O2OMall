package com.jixie.interceptor;

import com.jixie.bean.Users;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invacation) throws Exception {
		
		ActionContext actx = invacation.getInvocationContext();
		Users users = (Users) actx.getSession().get("users");
		if(users != null){
			return invacation.invoke();
		}else{
			return Action.LOGIN;
		}
	}

	
}
