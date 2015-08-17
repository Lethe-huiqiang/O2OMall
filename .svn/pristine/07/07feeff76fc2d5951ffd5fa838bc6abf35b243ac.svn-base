package com.jixie.message.email;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 简单邮件（不带附件的邮件）发送器
 */
public class SimpleMailSender {

	// public String[] filename=null;
	// public Vector file = new Vector(); //用于保存发送附件的文件名的集合

	/*    *//**
	 * 该方法用于收集附件名
	 */
	/*
	 * public void addAttachfile(String fname){ file.addElement(fname); }
	 */
	/**
	 * 以文本格式发送邮件
	 * 
	 * @param mailInfo
	 *            待发送的邮件的信息
	 */
	public static boolean sendTextMail(MailInfo mailInfo) {
		
		MyAuthenticator authenticator = null;// 判断是否需要身份认证
		Properties pro = mailInfo.getProperties();
		
		// 如果需要身份认证，则创建一个密码验证器
		if (mailInfo.getValidate()) {
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		
		try {
			Message mailMessage = new MimeMessage(sendMailSession);// 根据session创建一个邮件消息
			Address from = new InternetAddress(mailInfo.getFromAddress());// 创建邮件发送者地址
			mailMessage.setFrom(from);// 设置邮件消息的发送者
			
			// 创建邮件的接收者地址，并设置到邮件消息中
			for (int j = 0; j < mailInfo.getToAddress().length; j++) {
				Address to = new InternetAddress(mailInfo.getToAddress()[j]);
				
				mailMessage.addRecipient(Message.RecipientType.TO, to);// Message.RecipientType.TO属性表示接收者的类型为TO
			}
			
			// 创建邮件的抄送人地址，并设置到邮件消息中
			if (mailInfo.getCcAddress() != null) {
				for (int n = 0; n < mailInfo.getCcAddress().length; n++) {
					Address cc = new InternetAddress(mailInfo.getCcAddress()[n]);
					
					// Message.RecipientType.CC属性表示接收者的类型为CC
					mailMessage.addRecipient(Message.RecipientType.CC, cc);
				}
			}
			
			mailMessage.setSubject(mailInfo.getSubject());// 设置邮件消息的主题
			
			mailMessage.setSentDate(new Date());// 设置邮件消息发送的时间
			
			String mailContent = mailInfo.getContent();// 设置邮件消息的主要内容
			mailMessage.setText(mailContent);
			
			Transport.send(mailMessage);// 发送邮件
			
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 以HTML格式发送邮件
	 * 
	 * @param mailInfo
	 *            待发送的邮件信息
	 */
	@SuppressWarnings("static-access")
	public static boolean sendHtmlMail(MailInfo mailInfo) {
		
		MyAuthenticator authenticator = null;// 判断是否需要身份认证
		Properties pro = mailInfo.getProperties();
		
		// 如果需要身份认证，则创建一个密码验证器
		if (mailInfo.getValidate()) {
			authenticator = new MyAuthenticator(mailInfo.getUserName(),
					mailInfo.getPassword());
		}

		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			
			Address from = new InternetAddress(mailInfo.getFromAddress());// 创建邮件发送者地址
			
			mailMessage.setFrom(from);// 设置邮件消息的发送者

			// 创建邮件的接收者地址，并设置到邮件消息中
			for (int j = 0; j < mailInfo.getToAddress().length; j++) {
				Address to = new InternetAddress(mailInfo.getToAddress()[j]);
				
				mailMessage.addRecipient(Message.RecipientType.TO, to);// Message.RecipientType.TO属性表示接收者的类型为TO
			}

			// 创建邮件的抄送人地址，并设置到邮件消息中
			if (mailInfo.getCcAddress() != null) {
				for (int n = 0; n < mailInfo.getCcAddress().length; n++) {
					Address cc = new InternetAddress(mailInfo.getCcAddress()[n]);
					
					mailMessage.addRecipient(Message.RecipientType.CC, cc);// Message.RecipientType.CC属性表示接收者的类型为CC
				}
			}
			
			mailMessage.setSubject(mailInfo.getSubject());// 设置邮件消息的主题
			
			mailMessage.setSentDate(new Date());// 设置邮件消息发送的时间
			
			Multipart mainPart = new MimeMultipart();// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			
			BodyPart mbp = new MimeBodyPart();// 创建一个包含HTML内容的MimeBodyPart
			
			mbp.setContent(mailInfo.getContent(), "text/html; charset=utf-8");// 设置HTML内容
			mainPart.addBodyPart(mbp);
			
			// 添加附件
			String filename = "";
			String[] attachFileNames = mailInfo.getAttachFileNames();
			if (attachFileNames!=null&&attachFileNames.length > 0) {
				for (int w = 0; w < attachFileNames.length; w++) {
					mbp = new MimeBodyPart();
					filename = attachFileNames[w]; // 选择出每一个附件名
					FileDataSource fds = new FileDataSource(filename); // 得到数据源
					mbp.setDataHandler(new DataHandler(fds)); // 得到附件本身并至入BodyPart
					mbp.setFileName(fds.getName()); // 得到文件名同样至入BodyPart
					mainPart.addBodyPart(mbp);
				}
			}
			
			mailMessage.setContent(mainPart);// 将MiniMultipart对象设置为邮件内容
			
			//@SuppressWarnings("unused")
			//Transport transport=sendMailSession.getTransport();// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}