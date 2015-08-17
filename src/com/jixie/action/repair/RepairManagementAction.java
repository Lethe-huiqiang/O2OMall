package com.jixie.action.repair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.jixie.action.BaseAction;
import com.jixie.action.users.UsersHelper;
import com.jixie.bean.MemberAchievement;
import com.jixie.bean.MemberInfo;
import com.jixie.bean.RepairClaim;
import com.jixie.bean.RepairManagement;
import com.jixie.bean.Users;
import com.jixie.bean.LeaveWords;
import com.jixie.service.repairclaim.RepairManagementService;
import com.jixie.utils.Utils;
import com.opensymphony.xwork2.ActionContext;
import com.gzbugu.common.commonService.BaseService;
import com.gzbugu.common.commonService.ICommonService;
import com.gzbugu.common.query.PageModel;

public class RepairManagementAction extends BaseAction{
	
	private PageModel pageModel;
	private Users users;
	private RepairManagement repairmanagement;
	private RepairManagementService repairManagementService;
	private MemberAchievement memberachievement;
	private String calimId;
	private String id;
	private String repairMemId;
	private Timestamp dispatchTime;
	private Integer acceptState;
	private Timestamp getTime;
	private String comment;
	private Integer commentValue;
	
	public static Timestamp getCurrentTimestamp(){
		Timestamp creTime = Timestamp.valueOf(new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").format(new Date()));
		return creTime;
	}
	

	public String loginUI(){
		return LOGIN;
	}
	
	
//	public void test(){
//		RepairManagementHelper.updateFailRepairdo();
//	}
	
	//维修管理后台登陆
	public void login() throws IOException{
		
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
	
	
	
	//给组长看机主评论
	public String showbosscomment(){
		
		String sql = "select * from repair_management a inner join member_info b on a.repair_mem_id = b.id where a.comment is not null";
		try{
			List list = commonService.findListByNativeSQL(sql);
			
			ServletActionContext.getRequest().setAttribute("bosscomment", list);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "bosscomment";
	}
	
	
	//给组员看机主评论
	public String showmemcomment(){
		
		String urll = ServletActionContext.getRequest().getHeader("referer");
		
		System.out.println(urll);
		
		Users users = UsersHelper.getUsersFromSession();
		
		String Id = users.getId();
		
		String sql = "select * from repair_management a inner join repair_claim b on a.id = b.id where a.repair_mem_id = ? and b.state = ?";
		
		try{
			List list = commonService.findListByNativeSQL(sql, Id, 3);
			
			ServletActionContext.getRequest().setAttribute("memcomment", list);
			
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		
		return "memcomment";
	}
	
	
	//查看组员接单情况
	public String showachievement(){
		
		String sql = "select * from member_achievement m INNER JOIN member_info i ON m.id= i.id";
		
		try{
			List list = commonService.findListByNativeSQL(sql);
			
			ServletActionContext.getRequest().setAttribute("achievement", list);
		}
		catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "achievement";
	}
	
	
	//获取机主留言
	public String showleavewords(){
		
		Users users = UsersHelper.getUsersFromSession();
		
		String Id =	users.getId();
		
		try{
			String hql1 = "from RepairManagement r where r.repairMemId = ? and r.acceptState = ?";
			
			String hql = "from LeaveWords l";
			
			List list1 = commonService.findListByHQL(hql1, Id, 1);
			
			List list = commonService.findListByHQL(hql);
			
			List list2 = new ArrayList();
			
			for(int i = 0;i<list1.size();i++){
				for(int j = 0;j<list.size();j++){
					if(((LeaveWords) list.get(j)).getRepairClaimId().equals(((RepairManagement) list1.get(i)).getId())){
						list2.add(list.get(j));
					}
				}
			}
			
			ServletActionContext.getRequest().setAttribute("leavewords", list2);
		}
		catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "showleave";
	}
	
	
	//组长获取未处理的报修单信息，还有成员信息
	@SuppressWarnings("deprecation")
	public String gettable() throws Exception {
		
		try{
			//分页设置
			
			pageModel = new PageModel();
			//pageModel.setCurrentPage(0);
			pageModel.setPageSize(10);
			//ServletActionContext.getRequest().getSession().setAttribute("pageModel",pageModel);
			
			String hql = "from RepairClaim r where r.state = ?" ;
			
			String sql = "select * from member_info a inner join users b on a.id = b.id where a.group_id = ? and b.u_type = ?" ;
			
			PageModel pm = commonService.findPageByHQL(hql, pageModel,0);
			
			List list2 = commonService.findListByNativeSQL(sql, "1", "1");
			
			List<?> list = pm.getList();
			
			ServletActionContext.getRequest().setAttribute("mems",list2);
			ServletActionContext.getRequest().setAttribute("list",list);
			ServletActionContext.getRequest().setAttribute("pageModel",pageModel);
			
			

			
		}catch(Exception e){
			e.printStackTrace();
			this.sendMsgAjax("error", "UTF-8");
		}
		return "list";
	}
	
	//下一页
	public String getnextpage() throws Exception{
		
		try{
			
			//分页设置

			pageModel.setPageSize(10);
			//pageModel = (PageModel) ServletActionContext.getRequest().getSession().getAttribute("pageModel");
			//pageModel.setCurrentPage(pageModel.getCurrentPage()+1);
			//ServletActionContext.getRequest().getSession().setAttribute("pageModel",pageModel);
			
			String hql = "from RepairClaim r where r.state = ?" ;
			
			String sql = "select * from member_info a inner join users b on a.id = b.id where a.group_id = ? and b.u_type = ?" ;
			
			PageModel pm = commonService.findPageByHQL(hql, pageModel,0);
			
			List list = pm.getList();
			
			ServletActionContext.getRequest().setAttribute("list",list);
			ServletActionContext.getRequest().setAttribute("pageModel",pageModel);
			
			List list2 = commonService.findListByHQL(sql, "1", "1");
			ServletActionContext.getRequest().setAttribute("mems",list2);
			
		}catch(Exception e){
			e.printStackTrace();
			this.sendMsgAjax("error", "UTF-8");
		}
		return "list";
	}
	
	
	public String getpreviouspage() throws Exception{
		
		try{
			
			//分页设置

			pageModel.setPageSize(10);
			
			String hql = "from RepairClaim r where r.state = ?" ;
			
			String sql = "select * from member_info a inner join users b on a.id = b.id where a.group_id = ? and b.u_type = ?" ;
			
			PageModel pm = commonService.findPageByHQL(hql, pageModel,0);
			
			List list = pm.getList();
			
			ServletActionContext.getRequest().setAttribute("list",list);
			ServletActionContext.getRequest().setAttribute("pageModel",pageModel);
			
			List list2 = commonService.findListByHQL(sql, "1", "1");
			ServletActionContext.getRequest().setAttribute("mems",list2);
			
		}catch(Exception e){
			e.printStackTrace();
			this.sendMsgAjax("error", "UTF-8");
		}
		return "list";
	}
	
	
	//组员获取未处理的报修单信息
	public String getmemtable() throws Exception{
		
		try{
			Users users = UsersHelper.getUsersFromSession();
			
			String Id =	users.getId();
			
			int acceptState = 0;
			
			String hql = "from RepairManagement r where r.repairMemId = ? and r.acceptState = ?";
			
			List list = commonService.findListByHQL(hql, Id, acceptState);
			
			ServletActionContext.getRequest().setAttribute("repairdo",list);
			
		}catch(Exception e){
			e.printStackTrace();
			this.sendMsgAjax("error", "utf-8");
		}
		return "repairdo";
	}
	
	//按照组员ID查询未总结的维修单
	@SuppressWarnings("deprecation")
	public String getID() throws Exception{
		
		Users users = UsersHelper.getUsersFromSession();
				
		String Id =	users.getId();
	
		try{
			String sql = "select ID from repair_management where REPAIR_MEM_ID = ? and ACCEPT_STATE = ? and ID = any (select ID from repair_claim where STATE = 2)" ;
			
			List list = commonService.findListByNativeSQL(sql,Id,1);
			
			ServletActionContext.getRequest().setAttribute("repairmanagement",list);
			
			String hql2 = "from FaultLabel";
			
			List list2 = commonService.findListByHQL(hql2);
			
			ServletActionContext.getRequest().setAttribute("fault_label", list2);
			
		}catch(Exception e){
			e.printStackTrace();
			this.sendMsgAjax("error", "UTF-8");
		}
		return "repairmanagement";
	}
	
	
	//新建保修单
	
	public void repairmanagement(){
		
		String hql = "update RepairClaim r set r.state = 1 where r.id = ?";
		
	//	String hql2 = "from RepairManagement r where r.id = ?";
		
		String hql3 = "delete RepairManagement r where r.id = ?";
		
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		if(repairmanagement==null) 
			repairmanagement=new RepairManagement();
			
		try{
					
			RepairManagementHelper.getInstance().initRepairMInfo(repairmanagement);//初始化登记信息
			
/*			List list = commonService.findListByHQL(hql2,repairmanagement.getId());
			
			if(list.size() != 0){
				commonService.executeHQL(hql3,repairmanagement.getId());
			}*/
			
			//若有旧记录则删除
			commonService.executeHQL(hql3,repairmanagement.getId());
			
			repairManagementService.saveRepairManagement(repairmanagement);
			
		//	RepairManagementHelper.setRepairMToSession(repairmanagement);	
			
			commonService.executeHQL(hql,repairmanagement.getId());
						
			this.sendMsgAjax("yes", "utf-8");
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
	//修机成员接单
	@SuppressWarnings("deprecation")
	public void repairdo(){
		
		//成员工作情况记录
		Users users = UsersHelper.getUsersFromSession();
		
		String usersId = users.getId();
		
		String hql = "from MemberAchievement m where m.id = ?";
		String hql2 = "";
		String hql3 = "from RepairManagement r where r.id = ?";
		
		String hql4 = "update RepairManagement r set r.acceptState = 1 where r.id = ?";//默认为0，接受为1，拒绝为2，按时间判断未接单为3
		String hql5 = "update RepairClaim r set r.state = 2 where r.id = ?";//默认为0，派单后为1，接单后为2，结单后为3
		String hql6 = "update RepairManagement r set r.getTime = ? where r.id = ?";
		
		String Id = this.getCalimId();
		
		int acceptCount = 1;
		int refuseCount = 0;
		int achieveCount = 0;//默认为0
/*		int acceptstate = repairmanagement.getAcceptState();
		
		if(acceptstate == 1){
			acceptCount = 1;
		}
		else{
			refuseCount = 1;
		}*/
		
		//System.out.println(Id+"K");
		List<MemberAchievement> list = commonService.findListByHQL(hql, usersId);
		
		List<RepairManagement> list2 = commonService.findListByHQL(hql3, Id);
		
		System.out.println(list.size());
		System.out.println(list);
		
		//如果该ID未被记录进数据库
		if(list.size()==0){
			memberachievement = new MemberAchievement();
			memberachievement.setId(usersId);
			memberachievement.setAcceptCount(acceptCount);
			memberachievement.setRefuseCount(refuseCount);
			memberachievement.setAchieveCount(achieveCount);
			memberachievement.setUpdateTime(getCurrentTimestamp());	
			commonService.save(memberachievement);
		}
		else{
		//	if(acceptCount==1){
			hql2 = "update MemberAchievement m set m.acceptCount = m.acceptCount+1 where m.id = ?";
		//	}
		//	else{
		//		hql2 = "update MemberAchievement m set m.refuseCount = m.refuseCount+1";
		//	}
			commonService.executeHQL(hql2,usersId);
		}	
		
		//System.out.println(list2.get(0));
		
			//repairmanagement表的acceptState更新
			commonService.executeHQL(hql4,Id);
			commonService.executeHQL(hql6,getCurrentTimestamp(),Id);
			//repairclaim表的state更新
			commonService.executeHQL(hql5,Id);		
	}
	
	//修机成员拒单
	public void repairnotdo(){
		
		//成员工作情况记录
		Users users = UsersHelper.getUsersFromSession();
		
		String usersId = users.getId();
		
		String hql = "from MemberAchievement m where m.id = ?";
		String hql2 = "";
		String hql3 = "from RepairManagement r where r.id = ?";
		String hql4 = "update RepairManagement r set r.acceptState = 2 where r.id = ?";//默认为0，接受为1，拒绝为2，按时间判断未接单为3
		String hql5 = "update RepairClaim r set r.state = 0 where r.id = ?";//默认为0，派单后为1，接单后为2，结单后为3
		String hql6 = "update RepairManagement r set r.getTime = ? where r.id = ?";
		
		String Id = this.getCalimId();
		
		int acceptCount = 0;
		int refuseCount = 1;
		int achieveCount = 0;//默认为0
/*		int acceptstate = repairmanagement.getAcceptState();
		
		if(acceptstate == 1){
			acceptCount = 1;
		}
		else{
			refuseCount = 1;
		}*/
		
		//System.out.println(Id+"K");
		List<MemberAchievement> list = commonService.findListByHQL(hql, usersId);
		
		List<RepairManagement> list2 = commonService.findListByHQL(hql3, Id);
		
		System.out.println(list.size());
		System.out.println(list);
		
		
		//如果该ID未被记录进数据库
		if(list.size()==0){
			memberachievement = new MemberAchievement();
			memberachievement.setId(usersId);
			memberachievement.setAcceptCount(acceptCount);
			memberachievement.setRefuseCount(refuseCount);
			memberachievement.setAchieveCount(achieveCount);
			memberachievement.setUpdateTime(getCurrentTimestamp());	
			commonService.save(memberachievement);
		}
		else{
		//	if(acceptCount==1){
			hql2 = "update MemberAchievement m set m.refuseCount = m.refuseCount+1 where m.id = ?";
		//	}
		//	else{
		//		hql2 = "update MemberAchievement m set m.refuseCount = m.refuseCount+1";
		//	}
			commonService.executeHQL(hql2,usersId);
		}	
		
		//System.out.println(list2.get(0));
		
			//repairmanagement表的acceptState更新
			commonService.executeHQL(hql4,Id);
			commonService.executeHQL(hql6,getCurrentTimestamp(),Id);
			//repairclaim表的state更新
			commonService.executeHQL(hql5,Id);			
	}
	
	
	
	
	

	public RepairManagementService getRepairManagementService() {
		return repairManagementService;
	}



	public void setRepairManagementService(
			RepairManagementService repairManagementService) {
		this.repairManagementService = repairManagementService;
	}
	


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	public RepairManagement getRepairmanagement() {
		return repairmanagement;
	}
	public void setRepairmanagement(RepairManagement repairmanagement) {
		this.repairmanagement = repairmanagement;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getDispatchTime() {
		return dispatchTime;
	}



	public void setDispatchTime(Timestamp dispatchTime) {
		this.dispatchTime = dispatchTime;
	}



	public Timestamp getGetTime() {
		return getTime;
	}



	public void setGetTime(Timestamp getTime) {
		this.getTime = getTime;
	}



	public PageModel getPageModel() {
		return pageModel;
	}


	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}


	public MemberAchievement getMemberachievement() {
		return memberachievement;
	}


	public void setMemberachievement(MemberAchievement memberachievement) {
		this.memberachievement = memberachievement;
	}


	public String getRepairMemId() {
		return repairMemId;
	}
	public void setRepairMemId(String repairMemId) {
		this.repairMemId = repairMemId;
	}
	public Integer getAcceptState() {
		return acceptState;
	}
	public void setAcceptState(Integer acceptState) {
		this.acceptState = acceptState;
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


	public String getCalimId() {
		return calimId;
	}


	public void setCalimId(String calimId) {
		this.calimId = calimId;
	}
	

}
