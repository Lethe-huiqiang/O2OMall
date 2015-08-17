package com.jixie.action.repair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.jixie.action.BaseAction;
import com.jixie.action.users.UsersHelper;
import com.jixie.bean.LeaveWords;
import com.jixie.bean.RepairClaim;
import com.jixie.bean.RepairManagement;
import com.jixie.bean.Users;
import com.jixie.service.repairclaim.RepairClaimService;
import com.jixie.utils.Utils;

import com.gzbugu.common.commonService.ICommonService;
import com.gzbugu.common.commonService.impl.CommonServiceImpl;

public class RepairClaimAction extends BaseAction{
	
	

	private RepairClaim repairClaim;
	private RepairClaimService repairClaimService;
	private RepairManagement repairManagement;
	private LeaveWords leaveWords;
	private String words;
	private String macOwner;
	private String longTel;
	private String shortTel;
	private String address;
	private String machine;
	private String system;
	private Integer storage;
	private String description;


	/**
	 * 未登录，跳到登陆页面
	 * @return LOGIN
	 */
	public String loginUI(){
		return LOGIN;
	}
	
	/**
	 * 跳到错误页面
	 * @return ERROR
	 */
	public String errorUI(){
		return ERROR;
	}
	
	//维修登记
	public void repairclaim(){
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		if(repairClaim==null) 
			repairClaim=new RepairClaim();
			
		try{
			RepairClaimHelper.getInstance().initRepairInfo(repairClaim);//初始化登记信息
			
			repairClaimService.saveOrUpdateRepairClaim(repairClaim);
		
			RepairClaimHelper.setRepairToSession(repairClaim);
			
			this.sendMsgAjax("yes", "utf-8");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
	//显示机主的维修登记信息
	@SuppressWarnings("unchecked")
	public String showclaim(){
		Users users = UsersHelper.getUsersFromSession();
		
		if(users == null){
			return "login";
		}
		
		String macOwnerId =	users.getId();
		
		String kong = null;
		
		try{
			String hql = "FROM RepairClaim r WHERE r.macOwnerId = ?" ;//
			
			String sql = "select ID from repair_management where ID = any (select ID from repair_claim where MAC_OWNER_ID = ? ) and COMMENT is not ?";
			
			List<RepairClaim> list = commonService.findListByHQL(hql,macOwnerId);
			
			List commentedID = commonService.findListByNativeSQL(sql,macOwnerId,kong);
			
			for(int i = 0;i<list.size();i++){
			repairClaim = (RepairClaim) list.get(i);
			String Id = repairClaim.getId();
			for(int j = 0;j<commentedID.size();j++){
			String Idvali = commentedID.get(j).toString();
			if(repairClaim.getId().equals(Idvali)){
				repairClaim.setIsComment(true);
					}
				}
			list.set(i, repairClaim);
			}
			
			ServletActionContext.getRequest().setAttribute("show",list);
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return "show";		
	}
	
	
	//组员接单后显示机主报修信息
	@SuppressWarnings("unchecked")
	public String showmemclaim(){
		
		Users users = UsersHelper.getUsersFromSession();
		
		if(users == null){
			return "login";
		}
		
		String comment = null;
		
		String hql = "from RepairClaim r where r.state != ?";
		
		String sql = "select ID from repair_management where REPAIR_MEM_ID = ? and ACCEPT_STATE = ? and COMMENT is ?";
		
		String ID = users.getId();
		
	try{	
		List<?> list = commonService.findListByNativeSQL(sql, ID, 1, comment);
		
		if(list.size()!=0){
		List<RepairClaim> acceptedlist = new ArrayList();
		
		List list1 = commonService.findListByHQL(hql, 3);
		
		for(int i = 0;i < list.size();i++){
			for(int j = 0;j<list1.size();j++){
				if(((RepairClaim)list1.get(j)).getId().equals(list.get(i))){
				repairClaim = (RepairClaim) list1.get(j);
				acceptedlist.add(repairClaim);
				}
			}
		}
		
		ServletActionContext.getRequest().setAttribute("showmemclaim", acceptedlist);
		}
	}
	catch(Exception e){
		e.printStackTrace();
		
	}
		return "showmem";
	}
	
	
	
	//机主留言
	public void leavewords() throws Exception{
		
		// UUID号
		String Id = UUID.randomUUID().toString().replace("-", "");
		
		Users users = UsersHelper.getUsersFromSession();
		
		if(users == null){
			this.sendMsgAjax("请先登录", "UTF-8");
		}
		
		String macOwnerId =	users.getId();
		
		try {
			String hql = "FROM RepairClaim r WHERE r.macOwnerId = ?" ;//	
			
			List list = commonService.findListByHQL(hql,macOwnerId);
			
			repairClaim = (RepairClaim) list.get(0);
			
			leaveWords.setId(Id);
			leaveWords.setRepairClaimId(repairClaim.getId());
			leaveWords.setWords(leaveWords.getWords());
			
			commonService.save(leaveWords);
			
			this.sendMsgAjax("留言成功", "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//删除机主的维修登记信息
/*	public String deleteclaim(){
		Users users = UsersHelper.getUsersFromSession();
		
		String macOwnerId =	users.getId();
		
		try{
			String hql = "FROM RepairClaim r WHERE r.macOwnerId = ?" ;//	
			
			List list = commonService.findListByHQL(hql, macOwnerId);
			
			repairClaim = (RepairClaim) list.get(0);
			
			commonService.delete(repairClaim);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return "delete";
	}*/
	

	//判断是否重复登记,kong zhi!
	public void checkName() throws Exception{
			/*HttpServletRequest request = ServletActionContext.getRequest();
			String owner = Utils.null2Str(macOwner);
			if(!"".equals(owner)){*/
		
			Users users = UsersHelper.getUsersFromSession();
			
			String macOwnerId =	users.getId();
			
			try{
				String hql = "FROM RepairClaim r WHERE r.macOwnerId = ? and r.state != ?" ;//	
				
				List list = commonService.findListByHQL(hql, macOwnerId, 3);//macOwnerId
			
				if(list!=null&list.size()>0){
					
					this.sendMsgAjax("no", "UTF-8");//表示提交的机主名已登记
					
				}else{
					this.sendMsgAjax("yes", "UTF-8");//提交的机主名未登记
				}
			}catch(Exception e){
				e.printStackTrace();
				this.sendMsgAjax("error", "UTF-8");
			}
		}
		
		
	
	
	public RepairManagement getRepairManagement() {
		return repairManagement;
	}

	public void setRepairManagement(RepairManagement repairManagement) {
		this.repairManagement = repairManagement;
	}

	public LeaveWords getLeaveWords() {
		return leaveWords;
	}

	public void setLeaveWords(LeaveWords leaveWords) {
		this.leaveWords = leaveWords;
	}

	public RepairClaim getRepairClaim() {
		return repairClaim;
	}
	
	public void setRepairClaim(RepairClaim repairClaim) {
		this.repairClaim = repairClaim;
	}
	
	public RepairClaimService getRepairClaimService() {
		return repairClaimService;
	}
	
	public void setRepairClaimService(RepairClaimService repairClaimService) {
		this.repairClaimService = repairClaimService;
	}
		
	public String getMacOwner() {
		return macOwner;
	}
	public void setMacOwner(String macOwner) {
		this.macOwner = macOwner;
	}
	public String getLongTel() {
		return longTel;
	}
	public void setLongTel(String longTel) {
		this.longTel = longTel;
	}
	public String getShortTel() {
		return shortTel;
	}
	public void setShortTel(String shortTel) {
		this.shortTel = shortTel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public Integer getStorage() {
		return storage;
	}
	public void setStorage(Integer storage) {
		this.storage = storage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	
	
}
