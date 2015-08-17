package com.jixie.message.email;

import com.jixie.message.email.MailInfo;
import com.jixie.message.email.SimpleMailSender;

/**
 * 示例
 * @author zh
 *
 */
public class UseMailTest {

	public static void main(String[] args){ 
		MailInfo mailInfo=new MailInfo();
		String validateURL="http://localhost:8080/jixieweb/activate?id=123456&key=usersInfo.getRegistCode()";
		String content="<p>你好！</p><p>感谢你注册广东工业大学计算机协会网站。<br>你的登录邮箱为1576288049@qq.com" +
				"。请点击以下链接完成账号激活：</p>"+"<p><a target='_blank' href='"+validateURL+
						"'>"+validateURL+"</a></p><p>如果以上链接无效，请将地址复制到你的浏览器的地址栏以完成激活账号。（该链接48小时以内有效，失效后请重新注册）</p>";
		mailInfo.setValidate(true);
		mailInfo.setMailServerHost("smtp.yeah.net");
		mailInfo.setMailServerPort("25");
		mailInfo.setUserName("ca_gdut@yeah.net");
		mailInfo.setPassword("gdutjixie667347");
		mailInfo.setFromAddress("ca_gdut@yeah.net");
		mailInfo.setToAddress(new String[]{"1576288049@qq.com"});
		mailInfo.setSubject("激活你的账号");
		mailInfo.setContent(content);
		MailSenderProxy.mailSend(mailInfo);//发送邮箱验证邮件
		
     /*//这个类主要是设置邮件   
     MailInfo mailInfo = new MailInfo();    
     mailInfo.setMailServerHost("smtp.163.com");    
     mailInfo.setMailServerPort("25");    
     mailInfo.setValidate(true);    
     mailInfo.setUserName("iishck@163.com");    
     mailInfo.setPassword("38561201!@#");//您的邮箱密码    
     mailInfo.setFromAddress("iishck@163.com");    
     mailInfo.setToAddress(new String[]{"1576288049@qq.com"});    // iishck@163.com
     //mailInfo.setCcAddress(new String[]{"iishck@163.com"});
     mailInfo.setSubject("Java mail test");    
     mailInfo.setContent("this<br>is<br>a<br>java mail<br>test."); 
     //mailInfo.setAttachFileNames(new String[]{"C:\\Users\\iis\\Desktop\\note\\123.jpg"});
        //这个类主要来发送邮件   
     SimpleMailSender sms = new SimpleMailSender();   
         //sms.sendTextMail(mailInfo);//发送文体格式    
         sms.sendHtmlMail(mailInfo);//发送html格式   
*/   }  
}

/*

各大型邮箱smtp服务器及端口收集  

2011-11-22 17:18:58|  分类： php |举报 |字号 订阅

各大型邮箱smtp服务器及端口收集：

>新浪邮箱smtp服务器
外发服务器:smtp.vip.sina.com
收件服务器:pop3.vip.sina.com
新浪免费邮件
外发服务器:smtp.sina.com.cn
收件服务器:pop3.sina.com.cn
 
>163邮箱smtp服务器
pop： pop.163.com
smtp： smtp.163.com
 
>QQ邮箱smtp服务器及端口
接收邮件服务器：imap.qq.com，使用SSL，端口号993
发送邮件服务器：smtp.qq.com，使用SSL，端口号465或587

>yahoo邮箱smtp服务器
接：pop.mail.yahoo.com.cn
发：smtp.mail.yahoo.com
 
>126邮箱smtp服务器
pop： pop.126.com
smtp： smtp.126.com
新浪免费邮箱
POP3：pop.sina.com
SMTP：smtp.sina.com
SMTP端口号：25
 
新浪VIP邮箱
POP3：pop3.vip.sina.com
SMTP：smtp.vip.sina.com
SMTP端口号：25
 
新浪企业邮箱
POP3：pop.sina.com
SMTP：smtp.sina.com
SMTP端口号：25
 
雅虎邮箱
POP3：pop.mail.yahoo.cn
SMTP：smtp.mail.yahoo.cn
SMTP端口号：25
  
搜狐邮箱
POP3：pop3.sohu.com
SMTP：smtp.sohu.com
 SMTP端口号：25
 
TOM邮箱
POP3：pop.tom.com
SMTP：smtp.tom.com
 SMTP端口号：25
 
Gmail邮箱
POP3：pop.gmail.com
SMTP：smtp.gmail.com
SMTP端口号：587 或 25
 
QQ邮箱
POP3：pop.qq.com
SMTP：smtp.qq.com
SMTP端口号：25
 
 
263邮箱
域名：263.net
POP3：263.net
SMTP：smtp.263.net
SMTP端口号：25
 
域名：x263.net
POP3：pop.x263.net
SMTP：smtp.x263.net
SMTP端口号：25
 
域名：263.net.cn
POP3：263.net.cn
SMTP：263.net.cn
SMTP端口号：25
 
域名：炫我型
POP3：pop.263xmail.com
SMTP：smtp.263xmail.com
SMTP端口号：25
 
21CN  免费邮箱
POP3：pop.21cn.com
SMTP：smtp.21cn.com
IMAP：imap.21cn.com
SMTP端口号：25
 
21CN  经济邮邮箱
POP3：pop.21cn.com
SMTP：smtp.21cn.com
SMTP端口号：25
 
21CN  商务邮邮箱
POP3：pop.21cn.net
SMTP：smtp.21cn.net
SMTP端口号：25
  
21CN  快感邮箱
POP3：vip.21cn.com
SMTP：vip.21cn.com
SMTP端口号：25
 
21CN  Y邮箱
POP3：pop.y.vip.21cn.com
SMTP：smtp.y.vip.21cn.com
SMTP端口号：25
 
中华网任我邮邮箱
POP3：rwpop.china.com
SMTP：rwsmtp.china.com
 SMTP端口号：25
 
中华网时尚、商务邮箱
POP3：pop.china.com
SMTP：smtp.china.com
SMTP端口号：25
*/