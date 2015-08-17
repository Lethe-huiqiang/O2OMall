package com.jixie.action.users;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.jixie.action.BaseAction;
//import com.jixie.bean.OrderTest;
import com.jixie.bean.Users;
import com.opensymphony.xwork2.ActionContext;

public class TestCService extends BaseAction{
	
	
	public void commonServiceTest(){
		Users users = new Users();
		users.setId("12345678912345678912345678912345");
		users.setAuth(0);
		users.setCreTime(new Timestamp(new Date().getTime()));
		users.setEmail("");
		users.setNickname("");
		users.setPassword("");
		users.setStatus(0);
		users.setUType(0);
		
		try{
			/*CommonServiceImpl service = this.serviceGet();
			this.serviceGet().save(users);*/
			commonService.save(users);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*public String orderTest(){
		OrderTest order = new OrderTest();
		for(int i=0;i<5;i++){
			order.setCreateTime(new Timestamp(new Date().getTime()));
			order.setId(UUID.randomUUID().toString().replace("-", ""));
			order.setName(i+"");
			try{
				commonService.save(order);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		String hql = "from ordertest order by createtime";
		List<Object> list = (List)commonService.findListByHQL(hql);
		ActionContext ctx = ActionContext.getContext();
		Map<String,Object> request = (Map<String, Object>) ctx.get("request");
		request.put("list",list);
		return "orderTest";
	}*/
	
}