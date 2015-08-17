package com.jixie.action.repsummary;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.jixie.action.BaseAction;
import com.jixie.action.repair.RepairClaimHelper;
import com.jixie.action.users.UsersHelper;
import com.jixie.bean.RepairClaim;
import com.jixie.bean.Repsummary;
import com.jixie.bean.Users;
import com.jixie.service.repsummary.RepsummaryService;
import org.apache.struts2.ServletActionContext;


public class RepsummaryAction extends BaseAction{
	
	private Repsummary repsummary;
	private RepsummaryService repsummaryService;
	private String id;
	private String repairmemid;
	private String machine;
	private String description;
	private String label;
	private String solution;
	private Integer isShare;
	
	public String loginUI(){
		return LOGIN;
	}


	
	public void repsummary(){
		
		Users users = UsersHelper.getUsersFromSession();
		
		String Id = users.getId();
		
		String hql1 = "update MemberAchievement m set m.achieveCount = m.achieveCount + 1 where m.id = ?";
		
		String hql = "update RepairClaim r set r.state = ? where r.id = ? ";
		
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		if(repsummary==null) 
			repsummary=new Repsummary();
			
		try{
			RepsummaryHelper.getInstance().initRepsummaryInfo(repsummary);
			
			repsummaryService.saveRepsummary(repsummary);
				
			this.sendMsgAjax("yes", "utf-8");
			
			//结单
			commonService.executeHQL(hql, 3, repsummary.getId());
			
			commonService.executeHQL(hql1,Id);
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
/*	@SuppressWarnings("deprecation")
	public String getlabel() throws Exception{
	
		try{
			String hql = "from FaultLabel";
			List list = commonService.findListByHQL(hql);
			ServletActionContext.getRequest().setAttribute("faultlabel", list);
			
		}catch(Exception e){
			e.printStackTrace();
			this.sendMsgAjax("error", "UTF-8");
		}
		return "faultlabel";
	}*/
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRepairmemid() {
		return repairmemid;
	}

	public void setRepairmemid(String repairmemid) {
		this.repairmemid = repairmemid;
	}

	public Repsummary getRepsummary() {
		return repsummary;
	}
	public void setRepsummary(Repsummary repsummary) {
		this.repsummary = repsummary;
	}
	public RepsummaryService getRepsummaryService() {
		return repsummaryService;
	}
	public void setRepsummaryService(RepsummaryService repsummaryService) {
		this.repsummaryService = repsummaryService;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public Integer getIsShare() {
		return isShare;
	}
	public void setIsShare(Integer isShare) {
		this.isShare = isShare;
	}

	
	
}
