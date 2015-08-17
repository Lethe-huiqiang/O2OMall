package com.jixie.message.email;

/**
 * 发送邮件接口
 * @author zh
 *
 */
public class MailSenderProxy {

	public static boolean mailSend(MailInfo mailInfo){
		try{
		    /* //MailSenderInfo mailInfo = new MailSenderInfo();    
		     mailInfo.setMailServerHost(mailInfo.getMailServerHost());    
		     mailInfo.setMailServerPort(mailInfo.getMailServerPort());    
		     mailInfo.setValidate(mailInfo.getValidate());    
		     mailInfo.setUserName(mailInfo.getUserName());    
		     mailInfo.setPassword(mailInfo.getPassword());//您的邮箱密码    
		     mailInfo.setFromAddress(mailInfo.getFromAddress());    
		     mailInfo.setToAddress(mailInfo.getToAddress());    
		     //mailInfo.setCcAddress(mailInfo.getCcAddress());
		     mailInfo.setSubject(mailInfo.getSubject());    
		     mailInfo.setContent(mailInfo.getContent()); */
		     //mailInfo.setAttachFileNames(mainInfo.getAttachFileNames());//附件
		     SimpleMailSender sms = new SimpleMailSender();   
		     sms.sendHtmlMail(mailInfo);//发送文体格式    
		     //sms.sendTextMail(mailInfo);//发送html格式   
		     return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
