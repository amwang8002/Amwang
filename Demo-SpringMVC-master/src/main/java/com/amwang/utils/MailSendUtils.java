package com.amwang.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.amwang.common.LogBase;
import com.amwang.common.MailInfo;
import com.sun.mail.util.MailSSLSocketFactory;

/**
 * 邮件发送工具类
 * 
 * @author wangyao.m
 *
 */
public class MailSendUtils extends LogBase {

	private final static String host = "smtp.qq.com"; // sina的服务器
	private final static String formName = "783774470@qq.com";// 你的邮箱
	private final static String password = "mftfjymlsuzybfhe"; // 授权码
	private final static String replayAddress = "783774470@qq.com"; // 你的邮箱

	public static void sendHtmlMail(MailInfo info) throws Exception {
		info.setHost(host);
		info.setFormName(formName);
		info.setFormPassword(password); // 网易邮箱的授权码~不一定是密码
		info.setReplayAddress(replayAddress);

		Message message = getMessage(info);
		// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
		Multipart mainPart = new MimeMultipart();
		// 创建一个包含HTML内容的MimeBodyPart
		BodyPart html = new MimeBodyPart();
		// 设置HTML内容
		html.setContent(info.getContent(), "text/html; charset=utf-8");
		mainPart.addBodyPart(html);
		// 将MiniMultipart对象设置为邮件内容
		message.setContent(mainPart);
		Transport.send(message);
	}

	public static void sendTextMail(MailInfo info) throws Exception {

		info.setHost(host);
		info.setFormName(formName);
		info.setFormPassword(password); // 网易邮箱的授权码~不一定是密码
		info.setReplayAddress(replayAddress);
		Message message = getMessage(info);
		// 消息发送的内容
		message.setText(info.getContent());

		Transport.send(message);
	}

	@SuppressWarnings("static-access")
	private static Message getMessage(MailInfo info) throws Exception {
		final Properties p = System.getProperties();
		p.setProperty("mail.smtp.host", info.getHost());
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.transport.protocol", "SMTP");
		p.setProperty("mail.smtp.user", info.getFormName());
		p.setProperty("mail.smtp.pass", info.getFormPassword());

		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.ssl.socketFactory", sf);

		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.port", "465");

		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session session = Session.getInstance(p, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(p.getProperty("mail.smtp.user"), p.getProperty("mail.smtp.pass"));
			}
		});
		session.setDebug(true);
		Message message = new MimeMessage(session);
		// 消息发送的主题
		message.setSubject(info.getSubject());
		// 接受消息的人
		message.setReplyTo(InternetAddress.parse(info.getReplayAddress()));
		// 消息的发送者
		message.setFrom(new InternetAddress(p.getProperty("mail.smtp.user"), info.getFormTitle()));
		// 创建邮件的接收者地址，并设置到邮件消息中 ，多人收件
		message.setRecipients(Message.RecipientType.TO, new InternetAddress().parse(info.getToAddress()));
		// 创建邮件抄送接受地址，并设置到邮件消息中，多人收件
//		message.setRecipients(Message.RecipientType.CC, new InternetAddress().parse(null));
		// 创建邮件密送接受地址，并设置到邮件消息中，多人收件
//		message.setRecipients(Message.RecipientType.BCC, new InternetAddress().parse(null));
		// 消息发送的时间
		message.setSentDate(new Date());

		return message;
	}
}
