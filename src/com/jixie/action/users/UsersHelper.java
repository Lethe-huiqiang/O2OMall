package com.jixie.action.users;

import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gzbugu.common.commonService.ICommonService;
import com.jixie.bean.Activation;
import com.jixie.bean.UsersInfo;
import com.jixie.bean.Users;
import com.jixie.message.email.MailInfo;
import com.jixie.utils.Utils;
import com.opensymphony.xwork2.ActionContext;

public class UsersHelper {
	
	private static UsersHelper instance ;
	private static final Object obj = new  Object();
	
    /**
     * 单例模式
     * @return
     */
    public static UsersHelper getInstance(){
        if(instance==null){
            synchronized (obj) {
                if(instance==null){
                    instance = new UsersHelper();
                }
            }
        }
        return instance;
    }

	/**
	 * 初始化注册时的信息
	 */
	public void initRegisterInfo(Users users,UsersInfo usersInfo,MailInfo mailInfo, Activation activation){
		
		// UUID号
		String usersId = UUID.randomUUID().toString().replace("-", ""); // member表id
		String activateId = UUID.randomUUID().toString().replace("-", "");//activation表id
		Timestamp creTime = Utils.date2Stamp(new Date());
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		//初始化注册信息
		if(users!=null&&usersInfo!=null){
			users.setId(usersId);//UUID32位
			users.setPassword(Utils.md5(users.getPassword()));// 用MD5对密码加密
			users.setUType(0);//普通会员
			users.setStatus(0);//白名单
			users.setAuth(0);//未审核
			users.setCreTime(creTime);
			
			//初始化个人信息
			usersInfo.setId(usersId);
			usersInfo.setNickname(users.getNickname());
			usersInfo.setEmail(users.getEmail());
			usersInfo.setStatus(0);//普通会员
			//usersInfo.setPictureId("d09b5ec6872b400e0ba0d7431cc06c1b");
			usersInfo.setUpdateTime(creTime);
			usersInfo.setGrade(0);//用户论坛等级初始为0
			usersInfo.setRegistCode(Utils.GetRandomString(20));//获取20随机码作为用户的注册码（给其他用户作推荐码）
			
			activation.setId(activateId);
			activation.setUsersId(usersId);
			activation.setActivationKey(Utils.GetRandomString(25));//注册链接随机码
			activation.setCreateTime(creTime);//链接有效时间为48小时			
			
			String validateURL=basePath+"activate.action?id="+usersId+"&key="+activation.getActivationKey();
			String content="<p>你好！</p><p>感谢你注册广东工业大学计算机协会网站。<br>你的登录邮箱为"+
			users.getEmail()+"。请点击以下链接完成账号激活：</p>"+"<p><a target='_blank' href='"+validateURL+
							"'>"+validateURL+"</a></p><p>如果以上链接无效，请将地址复制到你的浏览器的地址栏以完成激活账号。（该链接48小时以内有效，失效后请重新注册）</p>";
			mailInfo.setValidate(true);
			mailInfo.setMailServerHost("smtp.yeah.net");
			mailInfo.setMailServerPort("25");
			mailInfo.setUserName("ca_gdut@yeah.net");
			mailInfo.setPassword("gdutjixie667347");
			mailInfo.setFromAddress("ca_gdut@yeah.net");
			mailInfo.setToAddress(new String[]{users.getEmail()});
			mailInfo.setSubject("激活你的账号");
			mailInfo.setContent(content);
			
		}
	}
	
	 /**
	  * 把users set进session
	  * @param users
	  */
	public static void setUsersToSession(Users users) {
		ServletActionContext.getRequest().getSession().setAttribute("users", users);
	}
	/**
	  * 从session获取users
	  */
	public static Users getUsersFromSession(){
		return (Users) ServletActionContext.getRequest().getSession().getAttribute("users");		
	} 
	/**
	 * 退出登录
	 * 从session清掉users
	 */
	public static void cleanUsersFromSession() {
		ServletActionContext.getRequest().getSession().invalidate();
	}

	
	/**
	 * 根据users获取对应userinfo
	 * @author linzhihua
	 * @param Users
	 * @return
	 */
	public UsersInfo getUsersInfoByU(ICommonService commonService){
		
		Users users=UsersHelper.getUsersFromSession();
		return  commonService.findById(users.getId(), new UsersInfo());
	}


	public static void setUsersInfoToSession(UsersInfo usersInfo) {
		ServletActionContext.getRequest().getSession().setAttribute("usersInfo", usersInfo);
	}

	public static UsersInfo getUsersInfoFromSession() {
		return (UsersInfo) ServletActionContext.getRequest().getSession().getAttribute("usersInfo");
	}
	/**
	 * 从session清掉usersInfo
	 */
	public static void cleanUsersInfoFromSession() {
		ServletActionContext.getRequest().getSession().removeAttribute("usersInfo");
	}

}
