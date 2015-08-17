package com.jixie.interceptor;

import com.jixie.bean.Users;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class StatusInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invacation) throws Exception {
		
		ActionContext actx = invacation.getInvocationContext();
		Users users = (Users) actx.getSession().get("users");
		if(users != null){
			if(users.getStatus() != 2){
				return invacation.invoke();
			}else{
				return "statusCheck";//被拉黑会员除了正常浏览之外，发起的其他请求，比如发帖，回帖，留言，发消息之类均返回拒绝页面
			}
		}else{
			return Action.LOGIN;
		}
	}
}
