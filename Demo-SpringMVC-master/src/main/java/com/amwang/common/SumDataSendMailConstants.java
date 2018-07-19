package com.amwang.common;

import org.springframework.util.StringUtils;

import com.amwang.utils.MailSendUtils;

public class SumDataSendMailConstants {

	public static void sendEmail(String title,String content) {
		
		String mail = "amwang8002@163.com,913275571@qq.com"; // 发送对象的邮箱  913275571@qq.com
		
		String [] mails = mail.split(",");
		for (int i = 0; i < mails.length; i++) {
			if (!StringUtils.isEmpty(mails[i])) {
				
				String mString = mails[i];
				MailInfo info = new MailInfo();
				info.setToAddress(mString);
				info.setSubject(title);
				info.setContent(content);
				try {
					MailSendUtils.sendHtmlMail(info);
				} catch (Exception e) {
					System.out.print("'" + title + "'的邮件发送失败！");
					e.printStackTrace();
				}
			}
		}
	}
}
