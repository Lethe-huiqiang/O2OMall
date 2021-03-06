package com.jixie.action.users;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sun.misc.Request;

import com.jixie.action.BaseAction;
import com.jixie.action.UploadHelper;
import com.jixie.bean.ActivateResult;
import com.jixie.bean.Activation;
import com.jixie.bean.FileSource;
import com.jixie.bean.Users;
import com.jixie.bean.UsersInfo;
import com.jixie.message.email.MailInfo;
import com.jixie.message.email.MailSenderProxy;
import com.jixie.service.users.UsersService;
import com.jixie.utils.Utils;
import com.opensymphony.xwork2.ActionContext;

import com.gzbugu.common.commonService.ICommonService;
import com.gzbugu.common.commonService.impl.CommonServiceImpl;

public class UsersAction extends BaseAction {

	private Users users;//注册实体
	private UsersInfo usersInfo;//详细信息
	private UsersService usersService; // 会员service实现类
	private String urlReferrer;//记录登录前url
	private String email;//登录时提交的email
	private String password;//登录时提交的password
	private String id;//邮箱验证激活方法的id参数
	private String key;//邮箱验证激活方法的regist_code参数
	private ActivateResult activateResult;//保存注册之后邮箱验证的结果信息
	private String referer;
	
	private File[] picture;//会员头像文件
	private String[] pictureFileName;//会员头像图片文件名
	
	/**
	 * @category 跳转到会员注册的界面
	 * @author zhihua 2014.7.23
	 * @return LOGIN
	 */
	public String registUI() {
		return "registUI";
	}
	
	/**
	 * @category 跳转到登录界面
	 * @author zhihua 2014.7.23
	 * @return LOGIN
	 */
	public String loginUI(){
		return LOGIN;
	}
	
	
	//寻找修机组员
/*	@SuppressWarnings("deprecation")
	public String getrepairMId() throws Exception {
		String groupId = "1";//维修小组号为1
		try{
			String hql = "from MemberGroup m where m.id = ?" ;
			List list = commonService.findListByHQL(hql, groupId);
			ServletActionContext.getRequest().setAttribute("mems",list);

			
		}catch(Exception e){
			e.printStackTrace();
			this.sendMsgAjax("error", "UTF-8");
		}
		return "mems";
	}*/

	
	/**
	 * @category 会员注册方法
	 * @author zhihua 2014.7.23
	 * @return  使用ajax提交注册信息，前台校验完后，后台校验账号信息是否有效，如果无效，返回提示信息
	 */	
	public void regist(){
		
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		if(usersInfo==null) 
			usersInfo=new UsersInfo();
		
		MailInfo mailInfo = new MailInfo();
		Activation activation =new Activation();
		
		try{
			UsersHelper.getInstance().initRegisterInfo(users, usersInfo,mailInfo,activation);//初始化注册信息
			
			usersService.saveUsersorUsersInfo(users, usersInfo,activation);//事务存储注册及个人详细信息
			
			//UsersHelper.setUsersToSession(users);
			//UsersHelper.setUsersInfoToSession(usersInfo);
			this.sendMsgAjax("yes", "utf-8");
			MailSenderProxy.mailSend(mailInfo);//发送邮箱验证邮件
			
		}catch(Exception e){
			e.printStackTrace();
		}		
//		return "usersInfoGet";//将在服务器内部跳至usesInfoUI()做个人信息回显;
	}	
	
	
	/**
	 * @category 邮箱验证激活
	 */
	@SuppressWarnings("unchecked")
	public String activate(){
		
		activateResult = new ActivateResult();
		activateResult.setActivateMsg("");//验证提示信息
		activateResult.setActivateEffect(0);//验证结果，1=成功，2=链接失效，3=链接无效，4=跳转失败，需要重新验证

		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> request = (Map<String, Object>) ctx.get("request");
		
		if(id!=null&&key!=null){
			
			
			String hql="from Activation a where a.usersId=? and  a.activationKey=?";
			List<Activation> li=commonService.findListByHQL(hql,id, key);
						
			if(li.size()>0){
				Timestamp currentTime=Utils.date2Stamp(new Date());
				int nowTime=(int) currentTime.getTime();
				
				UsersHelper.getInstance();
				
				Activation activation=(Activation)li.get(0);
				users=commonService.findById(id,new Users());
				UsersHelper.setUsersToSession(users);
				UsersInfo usersInfo = UsersHelper.getInstance().getUsersInfoByU(commonService);
				
				int createTime=(int) activation.getCreateTime().getTime();				
				if((nowTime-createTime)<172800000){//验证链接48小时内有效
					users.setAuth(1);
					UsersHelper.setUsersInfoToSession(usersInfo);
					try{
						commonService.saveOrUpdate(users);
						activateResult.setActivateMsg("验证成功，请先完善个人信息吧！");
						activateResult.setActivateEffect(1);
						request.put("activateResult", activateResult);
					}catch(Exception e){
						e.printStackTrace();
					}
				}else{
					activateResult.setActivateMsg("链接失效，请重新注册吧！");
					activateResult.setActivateEffect(2);
					usersService.deleteUsers(users, usersInfo);
					request.put("activateResult",activateResult);
					
				}
			}else{
				activateResult.setActivateMsg("该链接无效，请先注册！");
				activateResult.setActivateEffect(3);
				request.put("activateResult", activateResult);
			}
		}else{
			activateResult.setActivateMsg("跳转失败，请重新验证！");
			activateResult.setActivateEffect(4);
			request.put("activateResult", activateResult);
		}
		return "activateResult";
	}
	
	/**
	 * @category 跳转到会员修改资料页面, 回显信息
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String usersInfoUI() {

		try {
			Users users = UsersHelper.getUsersFromSession();
			if (users != null) {
				//if(UsersHelper.getUsersInfoFromSession()!=null)
				//usersInfo = UsersHelper.getUsersInfoFromSession();
				//else{
				//if(usersInfo==null)
				usersInfo = commonService.findById(users.getId(), new UsersInfo());
				//}

				/*
				 * ActionContext context = ActionContext.getContext();
				 * context.put("userinfo", userInfo);
				 * context.put("introduction", introduction);
				 * context.put("courtshipstd", courtShipStd);
				 */
				/*
				 * HttpServletRequest request =
				 * ServletActionContext.getRequest();
				 * request.setAttribute("userinfo", userInfo);
				 * request.setAttribute("introduction", introduction);
				 * request.setAttribute("courtshipstd", courtShipStd);
				 */
				//if(usersInfo.getFileSource()==null){
				FileSource fs = commonService.findById(usersInfo.getPictureId(), new FileSource());
				usersInfo.setFileSource(fs);
				//}
				ActionContext ctx = ActionContext.getContext();
				Map<String, Object> request = (Map<String, Object>) ctx.get("request");
				request.put("usersInfo", usersInfo);
				ActionContext.getContext().getValueStack().push(usersInfo);
			} else {
				// 如果没有登录返回登录页面
				return LOGIN;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "usersInfoUI";
	}
	
	/**
	 * @category 完备或修改会员详细信息的方法
	 * @throws Exception 
	 */
	public String usersInfoFulfil() throws Exception {
		//String re="";
		Users users = UsersHelper.getUsersFromSession();
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}	
		
		if (usersInfo != null) {
			// 记录更新时间
			usersInfo.setUpdateTime(Utils.getCurrentTimestamp());
		try {
			FileSource fs = new FileSource();
			String fsPath = "";
			if(picture!=null){
				List<FileSource> list = UploadHelper.getInstance().uploadMultipleFile(picture, pictureFileName, "/usersPicture/");
				if(list.size()>0){
					fs = list.get(0);
					usersInfo.setPictureId(fs.getId());
					fsPath = fs.getPath();
					usersInfo.setFileSource(fs);
				}
				usersService.saveOrUpdateUfFile(usersInfo, fs);
			}else{
				commonService.saveOrUpdate(usersInfo);
			}
			UsersHelper.cleanUsersInfoFromSession();
			//this.sendMsgAjax("fsPath", "utf-8");
				
			// 详细信息登记成功，跳转到会员中心
			//re = "usersMain";
			//this.sendMsgAjax("ok", "UTF-8");
		} catch (Exception e) {
			ActionContext.getContext().put("usersInfoMessage", "详细信息登记失败");
			e.printStackTrace();
			//this.sendMsgAjax("fail", "UTF-8");//return "usersInfoUI";//
		}
		}
		return "usersInfoGet";
	}
	
	/**
	 * @category 判断用户名,邮箱是否可用
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public void checkName() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String name_phone_mail = Utils.null2Str(request.getParameter("name_phone_mail"));
		String usersId = Utils.null2Str(request.getParameter("usersId"));//修改个人信息时检测填写的信息是否是自己的旧信息
		
		try{
			String hql = "from Users u where u.nickname = ? or  u.email = ? " ;//u.phone = ? or
			List list = commonService.findListByHQL(hql, name_phone_mail,name_phone_mail);//name_phone_mail,
			if(list!=null&list.size()>0){
				if(UsersHelper.getInstance().getUsersFromSession()!=null){
					String toId=((Users)list.get(0)).getId();
					if(toId.equals(usersId)){
						this.sendMsgAjax("yes", "UTF-8");//修改个人信息时检测填写的信息是否是自己的旧信息
					}else{
						this.sendMsgAjax("no", "UTF-8");//表示提交的邮箱已被注册
					}
				}
				else{
					this.sendMsgAjax("no", "UTF-8");//表示提交的邮箱已被注册
				}
			}else{
				this.sendMsgAjax("yes", "UTF-8");//提交的邮箱未被注册
			}
		}catch(Exception e){
			e.printStackTrace();
			this.sendMsgAjax("error", "UTF-8");
		}
	}

	
	/**************************注册验证码校验******************************/
	private String rand; //表单中的rand
	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}
	
	public String checkRandomNumRegister(){ 
		//从session中取出RandomAction.java 中生成的验证码random
		String arandom=(String)(ActionContext.getContext().getSession().get("random"));
	
		//下面就是将session中保存验证码字符串与客户输入的验证码字符串对比了
		if(arandom.equals(this.getRand())) {
			
			ActionContext.getContext().getSession().put("user", users);
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	/*    <!-- Random验证码 -->  
    <action name="rand" class="com.mxl.rand.RandomAction">     
           <result type="stream">     
                <param name="contentType">image/jpeg</param>     
                <param name="inputName">inputStream</param>     
           </result>  
       </action>  
       */
	/**************************注册验证码校验******************************/
	
	/**
	 *	@category 登录方法
	 * 	登录账号字段：email
	 * 	登录密码字段：password
	 * @author zhihua 2014.7.25
	 * @return
	 * @throws IOException 
	 */
	public void login() throws IOException{
			
		String loginEmail = this.getEmail(); // 用户用于登陆的邮箱
		String password = Utils.md5(this.getPassword()); // 用户用于登陆的密码，经过加密
		
		String hql = "FROM Users u WHERE u.email=? and u.password=?";
		
		String referer = ServletActionContext.getRequest().getHeader("referer");
		
		//if(referer.contains(".jsp")|referer.equals(null)){
			referer = this.getReferer();
		//}
		
		
		try{
		List<Users> list = commonService.findListByHQL(hql,  new Object[]{loginEmail, password});
		
		if(list.size()>0){
			Users users=list.get(0);
			UsersHelper.setUsersToSession(users);
			this.sendMsgAjax(referer, "utf-8");
			}
		else{
			this.sendMsgAjax("wrong", "utf-8");
		}
		}catch(Exception e){
			e.printStackTrace();
			this.sendMsgAjax("error", "utf-8");
		}			
		
//		return re;
	}
	
	
	/**
	 * @category 会员头像上传
	 */
	public void pictureUpload(){
		try{
			UsersInfo usersInfo = UsersHelper.getUsersInfoFromSession();
			FileSource fs = new FileSource();
			String fsPath = "";
			if(picture.length>0){
				List<FileSource> list = UploadHelper.getInstance().uploadMultipleFile(picture, pictureFileName, "/usersPicture/");
				if(list.size()>0){
					fs = list.get(0);
					usersInfo.setPictureId(fs.getId());
					fsPath = fs.getPath();
				}
			}
			usersService.saveOrUpdateUfFile(usersInfo, fs);
			this.sendMsgAjax("fsPath", "utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * test method for mysql auto_increment
	 * @return
	 */
	/*public void autoIncrementTest(){
		test=new Test();
		if(test!=null){
			test.setAge(10);
			test.setName("testname");
		}
		try{
			commonService.save(test);
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		TestA testa=new TestA();
		TestB testb=new TestB();
		if(testa!=null&&testb!=null){
			testa.setId("1");
			testa.setGrade(1);
			testb.setId("1");
			testb.setGrade(2);
			testb.setTestA(testa);
		
			try{
				usersService.saveTestATestB(testa, testb);				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}*/
	
	public void testCommonService(){
		Users users = new Users();
		users.setAuth(0);
		users.setCreTime(new Timestamp(new Date().getTime()));
		users.setEmail("");
		users.setId("");
		users.setNickname("test");
		users.setPassword("");
		users.setStatus(0);
		users.setUType(0);
		try{
			commonService.save(users);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * test order by timestamp
	 * @return
	 */
/*	public String orderTest(){
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
		String hql = "from OrderTest orderT order by orderT.createTime asc";//"from ordertest orderT order by orderT.createTime";
		@SuppressWarnings("deprecation")
		List<OrderTest> list = commonService.findListByHQL(hql);
		ActionContext ctx = ActionContext.getContext();
		Map<String,Object> request = (Map<String, Object>) ctx.get("request");
		request.put("list",list);
		return "orderTest";
	}*/
	
	//成员退出
	public String logouts(){
		UsersHelper.cleanUsersFromSession();
		return "logouts";
	}
	
	
	//退出登录
	public String adlogout(){
		UsersHelper.cleanUsersFromSession();
		return "adlogout";
	}
	
	
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public UsersInfo getUsersInfo() {
		return usersInfo;
	}
	public void setUsersInfo(UsersInfo usersInfo) {
		this.usersInfo = usersInfo;
	}
	
	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public String getUrlReferrer() {
		return urlReferrer;
	}

	public void setUrlReferrer(String urlReferrer) {
		this.urlReferrer = urlReferrer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ActivateResult getActivateResult() {
		return activateResult;
	}

	public void setActivateResult(ActivateResult activateResult) {
		this.activateResult = activateResult;
	}

	public File[] getPicture() {
		return picture;
	}

	public void setPicture(File[] picture) {
		this.picture = picture;
	}

	public String[] getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureFileName(String[] pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}	
}
