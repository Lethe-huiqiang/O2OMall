package com.jixie.action.repsummary;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.jixie.action.BaseAction;
import com.jixie.action.repair.RepairManagementHelper;
import com.jixie.action.users.UsersHelper;
import com.jixie.bean.RepairClaim;
import com.jixie.bean.RepairManagement;
import com.jixie.bean.Users;

public class CommentAction extends BaseAction{
	
	private RepairManagement repairmanagement;
	private int idIndex;
	private String comment;
	private Integer commentValue;
	
	
	public String finishGetID(){
		return "finish";
	}
	
	
	public String getID() throws Exception{
		Users users = UsersHelper.getUsersFromSession();
		
		String macOwnerId = users.getId();
		
		String ID = null;
		
		String hql = "from RepairClaim r where r.macOwnerId = ?";
		
		idIndex = this.getIdIndex();
		
		try{
			List list = commonService.findListByHQL(hql,macOwnerId);
			
			RepairClaim repairclaim = (RepairClaim) list.get(idIndex);
			
			ID = repairclaim.getId();
			
			RepairManagementHelper.setRepairMToSession((RepairManagement)commonService.findById(ID, new RepairManagement()));
			
		}catch(Exception e){
			e.printStackTrace();
			this.sendMsgAjax("error", "UTF-8");
		}
		return "comment";
	}
	
	//机主反馈信息
	public String comment(){
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String p1 = repairmanagement.getComment();
		Integer p2 = repairmanagement.getCommentValue();
		
		repairmanagement = RepairManagementHelper.getRepairMFromSession();
		
		if(repairmanagement==null){
			return "showclaim";
		}
		
		repairmanagement.setComment(p1);
		repairmanagement.setCommentValue(p2);
		
		commonService.saveOrUpdate(repairmanagement);
		
		return SUCCESS;
	}
	
	
	public int getIdIndex() {
		return idIndex;
	}

	public void setIdIndex(int idIndex) {
		this.idIndex = idIndex;
	}

	public RepairManagement getRepairmanagement() {
		return repairmanagement;
	}

	public void setRepairmanagement(RepairManagement repairmanagement) {
		this.repairmanagement = repairmanagement;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getCommentValue() {
		return commentValue;
	}
	public void setCommentValue(Integer commentValue) {
		this.commentValue = commentValue;
	}

}
