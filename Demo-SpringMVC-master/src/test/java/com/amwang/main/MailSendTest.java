package com.amwang.main;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.serverModel.dao.TbeisaiDataDao;
import com.amwang.biz.serverModel.dao.TgetdataConfigDao;
import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.biz.serverModel.entity.TgetdataConfig;
import com.amwang.common.MailInfo;
import com.amwang.common.SumDataSendMailConstants;
import com.amwang.utils.JsonUtils;
import com.amwang.utils.MailSendUtils;

public class MailSendTest extends AbstractSpringContextTestSupport{
	
	@Autowired
	private TbeisaiDataDao tbeisaiDataDao;
	
	@Autowired
	private TgetdataConfigDao configDao;

	@Test
	public void sendMailTest() {
		TgetdataConfig config = configDao.getConfig();
		String mail = config.getMailTo();
		String title = config.getMailTitle();
		String content = "这是测试邮件";
		String subject = config.getMailSubject();
		
		SumDataSendMailConstants.sendEmail(mail, title, content,subject);
	}
	
	
	@Test
	public void sendMailddTest() {
		
		TgetdataConfig config = configDao.getConfig();
		int min = config.getMaxTime();
		String mail = config.getMailTo();
		
		List<TbeisaiData> result = tbeisaiDataDao.sumNums(min);
		String textno = Integer.valueOf(result.get(0).getTextno())+1+"";
		//定义一个二维数组 10行10列
		String arr[][] = new String[10][min];
		if (!CollectionUtils.isEmpty(result) && result.size() > 5) {
			for (int i = 0; i < min ; i++) {
				TbeisaiData record = result.get(i);
				arr[0][i]  = record.getNum1(); 
				arr[1][i]  = record.getNum2(); 
				arr[2][i]  = record.getNum3(); 
				arr[3][i]  = record.getNum4(); 
				arr[4][i]  = record.getNum5(); 
				arr[5][i]  = record.getNum6(); 
				arr[6][i]  = record.getNum7(); 
				arr[7][i]  = record.getNum8(); 
				arr[8][i]  = record.getNum9(); 
				arr[9][i]  = record.getNum10();
			}
			
			System.out.println(JsonUtils.obj2JsonString(arr));
		}
		int h = 1;
//		for (String[] strings : arr) {
			int i = 0; //偶数
			int f = 0; //奇数
			int s = 0; //小
			int b = 0; //大
			/**
			 * 单、双判断
			 */
		String [] strings = new String[]{"9","3","3","2","2","2","5"};
			for (String string : strings) {
				int a = Integer.valueOf(string);
				if (a%2 == 0) {
					i++;
					f = 0; // 奇数置位0
				} else {
					f++;
					i = 0; // 偶数置位0
				}
				
				if (i >= min) {
					// 如果全是偶数
					String content = "<div>第"+textno+"期-第"+h+"名:建议买【单】</div>目前【 "+i+" 个双】</div><br/><hr/>";
				}
				if (f >= min) {
					//全是奇数
					String content = "<div>第"+textno+"期-第"+h+"名:建议买【双】</div>目前【 "+f+" 个单】</div><br/><hr/>";
				}
			}
			
			/**
			 * 大小判断
			 */
			for (String string : strings) {
				int a = Integer.valueOf(string);
				if (0 < a && a < 6) {
					s++;
					b = 0; //大置位0
				} else {
					b++;
					s = 0; //小置位0
				}
				
				if (s >= min) {
					//全是小
					String content = "<div>第"+textno+"期-第"+h+"名:建议买【大】</div>目前【 "+s+" 个小】</div><br/><hr/>";
				} 
				if (b >= min) {
					//全是大
					String content = "<div>第"+textno+"期-第"+h+"名:建议买【小】</div>目前【 "+b+" 个大】</div><br/><hr/>";
				}
			}
			h++;
//		}
	}
	
	@Test
	public void arrayTest() {
		String textno = "00000";
		int h = 0;
		int min = 7;
		int i = 0; //偶数
		int f = 0; //奇数
		int s = 0; //小
		int b = 0; //大
		
		String [] strings = new String[]{"2","2","4","2","2","2","4"};
		for (String string : strings) {
			int a = Integer.valueOf(string);
			if (a%2 == 0) {
				i++;
				f = 0; // 奇数置位0
			} else {
				f++;
				i = 0; // 偶数置位0
			}
			
			if (i >= min) {
				// 如果全是偶数
				String content = "<div>第"+textno+"期-第"+h+"名:建议买【单】</div>目前【 "+i+" 个双】</div><br/><hr/>";
				System.out.println(content);
			}
			if (f >= min) {
				//全是奇数
				String content = "<div>第"+textno+"期-第"+h+"名:建议买【双】</div>目前【 "+f+" 个单】</div><br/><hr/>";
				System.out.println(content);
			}
		}
		
		/**
		 * 大小判断
		 */
		for (String string : strings) {
			int a = Integer.valueOf(string);
			if (0 < a && a < 6) {
				s++;
				b = 0; //大置位0
			} else {
				b++;
				s = 0; //小置位0
			}
			
			if (s >= min) {
				//全是小
				String content = "<div>第"+textno+"期-第"+h+"名:建议买【大】</div>目前【 "+s+" 个小】</div><br/><hr/>";
				System.out.println(content);
			} 
			if (b >= min) {
				//全是大
				String content = "<div>第"+textno+"期-第"+h+"名:建议买【小】</div>目前【 "+b+" 个大】</div><br/><hr/>";
				System.out.println(content);
			}
		}
		h++;
	}
	
	public static void main(String[] args) {
		
		String mail = "amwang8002@163.com,amwang8002@sina.com";
		String title = "test";
		String content = "这是测试邮件";
		
		String mString = mail;
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
