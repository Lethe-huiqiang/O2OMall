package com.jixie.message.email;   
/**   
* 邮件信息类，管理发送邮件需要使用的基本信息 
* 
*/    
import java.util.Properties;    
public class MailInfo {    
    
    private String mailServerHost;    // 发送邮件的服务器的IP和端口    
    private String mailServerPort;    
    private String fromAddress;    // 邮件发送者的地址    
    private String[] toAddress;    // 邮件接收者的地址    
    private String[] ccAddress; // 邮件抄送人的地址
    private String userName;    // 登陆邮件发送服务器的用户名和密码    
    private String password;    // 是否需要身份验证    
    private boolean validate = false;    //身份认证
    private String subject;    // 邮件主题 
    private String content;    // 邮件的文本内容    
    private String[] attachFileNames;      // 邮件附件的文件名   
    /**   
      * 获得邮件会话属性   
      */    
    public Properties getProperties(){    
      Properties p = new Properties();    
      p.setProperty("mail.transport.protocol", "smtp");
      p.put("mail.smtp.host", this.mailServerHost);    
      p.put("mail.smtp.port", this.mailServerPort);    
      p.put("mail.smtp.auth", validate ? "true" : "false");    
      return p;    
    }    
    public String getMailServerHost() {    
      return mailServerHost;    
    }    
    public void setMailServerHost(String mailServerHost) {    
      this.mailServerHost = mailServerHost;    
    }   
    public String getMailServerPort() {    
      return mailServerPort;    
    }   
    public void setMailServerPort(String mailServerPort) {    
      this.mailServerPort = mailServerPort;    
    }   
    public boolean getValidate() {    
      return validate;    
    }   
    public void setValidate(boolean validate) {    
      this.validate = validate;    
    }   
    public String[] getAttachFileNames() {    
      return attachFileNames;    
    }   
    public void setAttachFileNames(String[] fileNames) {    
      this.attachFileNames = fileNames;    
    }   
    public String getFromAddress() {    
      return fromAddress;    
    }    
    public void setFromAddress(String fromAddress) {    
      this.fromAddress = fromAddress;    
    }   
    public String getPassword() {    
      return password;    
    }   
    public void setPassword(String password) {    
      this.password = password;    
    }   
    public String[] getToAddress() {    
      return toAddress;    
    }    
    public void setToAddress(String[] toAddress) {    
      this.toAddress = toAddress;    
    }    
    public String[] getCcAddress() {
		return ccAddress;
	}
	public void setCcAddress(String[] ccAddress) {
		this.ccAddress = ccAddress;
	}
	public String getUserName() {    
      return userName;    
    }   
    public void setUserName(String userName) {    
      this.userName = userName;    
    }   
    public String getSubject() {    
      return subject;    
    }   
    public void setSubject(String subject) {    
      this.subject = subject;    
    }   
    public String getContent() {    
      return content;    
    }   
    public void setContent(String textContent) {    
      this.content = textContent;    
    }    
}   