package com.amwang.common;

import org.springframework.util.StringUtils;

import com.amwang.utils.MailSendUtils;

public class SumDataSendMailConstants {

	public static void sendEmail(String mailTo,String title,String content,String subject) {
		if (!StringUtils.isEmpty(mailTo)) {
			
			MailInfo info = new MailInfo();
			info.setToAddress(mailTo);
			info.setSubject(subject);
			info.setContent(content);
			info.setFormTitle(title);
			try {
				MailSendUtils.sendHtmlMail(info);
			} catch (Exception e) {
				System.out.print("'" + title + "'的邮件发送失败！");
				e.printStackTrace();
			}
		}
	}
}
