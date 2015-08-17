package com.jixie.action.users;

import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jixie.utils.Utils;

import com.jixie.action.BaseAction;
import com.jixie.bean.ChangePassKey;
import com.jixie.bean.Users;
import com.jixie.message.email.MailInfo;
import com.jixie.message.email.MailSenderProxy;
//import util.Utils;

public class ForgetPassAction extends BaseAction{
	//忘记密码，邮件发送修改密码的链接
		public String sendPsEmail(){
			HttpServletRequest request = ServletActionContext.getRequest();
			try {
				String retu = "";
				
				String emailStr = request.getParameter("mail");
				if(emailStr!=null){
					String usersId = null;
					List<Users> list = commonService.findListByHQL("from Users u where u.email = ?", emailStr);
					if(list!=null&&list.size()>0){
						Users user = (Users)list.get(0);
						usersId = user.getId();
						List<ChangePassKey> lit = commonService.findListByHQL("from ChangePassKey c where c.userId = ?", usersId);
						if(lit.size()>1){
							//this.sendMsgAjax("toomuch", null);//之前已经提交过忘记密码重置请求，完成上一次重置操作前不能继续申请
							request.setAttribute("message", "* 您之前有提交过重置密码请求，请到邮箱查收链接！");
							return "forgetPass";
						}
					}else{
						//this.sendMsgAjax("none", null);//不存在该邮箱对应账号
						request.setAttribute("message", "* 不存在该邮箱，请检查输入的邮箱是否正确！");
						return "forgetPass";
					}
					//保存修改密码的校验随机码
					String uuid = UUID.randomUUID().toString().replace("-", "");
					ChangePassKey change = new ChangePassKey();
					change.setKeyword(uuid);
					change.setUserId(usersId);
					change.setCreTime(new Timestamp(new Date().getTime()));
					commonService.save(change);
					
					String path = ServletActionContext.getServletContext().getRealPath("/email.properties");
					//读取邮件设置信息
					//InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
					FileInputStream inputStream = new FileInputStream(path);
					Properties properties = new Properties(); 
					properties.load(inputStream);
					inputStream.close();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
					Date date = new Date(System.currentTimeMillis());
					String dateStr = formatter.format(date);
					String validateURL=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" + "change.action?id="+usersId+"&key="+change.getKeyword();
					String content = "<p>您好，您收到这封邮件是因为您于" + dateStr + "向广东工业大学计算机协会网站提交修改忘记密码的请求，请点击" +
							"<a href=" + validateURL +" style='font-weight:bold;color:red;'>" + "修改密码</a>"  +
								"进入修改密码的页面。24小时内修改密码有效。" + 
							"如果您没有提交修改忘记密码的请求，请忽略这封邮件，请不要向他人泄露该邮件，这可能关系到您的账号安全。</p>" 
							;
					MailInfo mailInfo = new MailInfo();
					mailInfo.setValidate(true);
					mailInfo.setMailServerHost(properties.getProperty("mailServerHost"));
					mailInfo.setMailServerPort(properties.getProperty("mailServerPort"));
					mailInfo.setUserName(properties.getProperty("userName"));
					mailInfo.setPassword(properties.getProperty("password"));
					mailInfo.setFromAddress(properties.getProperty("fromAddress"));
					mailInfo.setToAddress(new String[]{emailStr});
					mailInfo.setSubject("修改密码");
					mailInfo.setContent(content);
					try {
						MailSenderProxy.mailSend(mailInfo);//发送邮箱验证邮件
					} catch (Exception e) {
						e.printStackTrace();
					}
					request.setAttribute("message","提交成功，重置密码链接已发送至你的邮箱，请在24小时内操作！");
					return "uselessUI";
					//this.sendMsgAjax("ok",null);
				}
				return "uselessUI";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message","提交失败，请稍后再试！");
				return "uselessUI";
			}
			 
//			return "changePass";
		}
		
		//修改密码页面跳转链接
		public String changePassUI(){
			HttpServletRequest request = ServletActionContext.getRequest();
			String userId = request.getParameter("id");
			String keyWord = request.getParameter("key");
			if(userId!=null&&keyWord!=null){
				try{
					List<ChangePassKey> list = commonService.findListByHQL("from ChangePassKey c where c.userId = ? and c.keyword = ?", userId,keyWord);
					if(list!=null&&list.size()>0){
						int nowTime=(int) new Timestamp(new Date().getTime()).getTime();
						int createTime=(int) ((ChangePassKey)(list.get(0))).getCreTime().getTime();
						if(nowTime-createTime<=86400000){//24小时内修改密码有效
							request.setAttribute("userId", userId);
							request.setAttribute("key", keyWord);
							return "changePassUI";
						}else{
							request.setAttribute("message", "该链接无效！");
							return "uselessUI";
						}
					}else{
						request.setAttribute("message", "该链接无效！");
						return "uselessUI";
					}
				}catch(Exception e){
					e.printStackTrace();
					request.setAttribute("message", "重置密码失败！");
					return "uselessUI";
				}
			}else{
				request.setAttribute("message", "该链接无效！");
				return "uselessUI";
			}
			
		}
		
		
		//忘记密码重置
		public void changePass(){
			HttpServletRequest request = ServletActionContext.getRequest();
			try {
				String keyWord = request.getParameter("key");
				String userId = request.getParameter("userId");
				String newPass = request.getParameter("newpassword");
				String reNewPass = request.getParameter("repassword");
				Users user = commonService.findById(userId, new Users());
				if(user!=null&&newPass.equals(reNewPass)){				 
					user.setPassword(Utils.md5(newPass));
					commonService.update(user);
					List<ChangePassKey> list = commonService.findListByHQL("from ChangePassKey c where c.userId = ? and c.keyword = ?", userId,keyWord);
					if(list!=null&&list.size()>0)
						commonService.delete((ChangePassKey)list.get(0));
					this.sendMsgAjax("修改密码成功！<a href='commodity_showCommodityList.action' >商城首页</a>", "utf-8");
					
					//request.setAttribute("message", "修改密码成功！");
					
					//return "uselessUI";
					//this.sendMsgAjax("ok", null);
					//return "login";
				}else{
					request.setAttribute("message", "该请求无效！");
					//return "uselessUI";
					//request.setAttribute("message", "该请求无效！");
					this.sendMsgAjax("修改密码失败！", "utf-8");
					//return "uselessUI";
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "该请求失败！");
				//return "uselessUI";
				//request.setAttribute("message", "该请求失败！");
				/*try {
					this.sendMsgAjax("fail", null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}*/
				//return "uselessUI";
			}
		}
}
