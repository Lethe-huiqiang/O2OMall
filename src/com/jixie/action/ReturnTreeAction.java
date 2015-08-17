package com.jixie.action;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.jixie.bean.RepairClaim;

public class ReturnTreeAction extends BaseAction{
	
	private String result;
	
	public void ReturnTree() throws Exception {
		
		String hql = "from RepairClaim" ;
		List<RepairClaim> list = commonService.findListByHQL(hql);
		ServletActionContext.getRequest().setAttribute("list",list);
		JSONArray ja = JSONArray.fromObject(list);
		System.out.println(ja);
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<list.size();i++){
			//sb.append(list.get(i).toJson());
			System.out.println(sb.toString());
		}
		
		//this.result = ja.toString();
		this.sendMsgAjax(sb.toString(), "UTF-8");
	
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
