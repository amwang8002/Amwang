package com.amwang.main;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.serverModel.dao.TbeisaiDataDao;
import com.amwang.biz.serverModel.dao.TgetdataConfigDao;
import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.biz.serverModel.entity.TgetdataConfig;
import com.amwang.biz.service.MyserverGetDataService;
import com.amwang.common.SumDataSendMailConstants;
import com.amwang.utils.DateUtil;
import com.amwang.utils.JsonUtils;

public class GetDataTest extends AbstractSpringContextTestSupport {

	@Autowired
	private MyserverGetDataService service;
	
	@Autowired
	private TbeisaiDataDao tbeisaiDataDao;
	
	@Autowired
	private TgetdataConfigDao configDao;
	
	@Test
	public void getConfigTest() {
		TgetdataConfig result = configDao.getConfig("t2");
		System.out.println(JsonUtils.obj2JsonString(result));
		
	}
	
	@Test
	public void testquerySumTest() {
		log.info("查询汇总配置开始：{}",DateUtil.getCurrentTimeStamp());
		TgetdataConfig config = configDao.getConfig("t1");
		int min = config.getMaxTime();
		String mail = config.getMailTo();
		log.info("查询结果：{}",JsonUtils.obj2JsonString(config));
		
		String title = "北京赛车计划";
		String queryDate = "2018-07-18";
		log.info("汇总每个名次开始，汇总日期-当天：{}",queryDate);
		List<TbeisaiData> result = tbeisaiDataDao.sumNums(min);
		
		String textno = Integer.valueOf(result.get(0).getTextno())+1+"";
		//定义一个二维数组 10行10列
		String arr[][] = new String[10][10];
		if (!CollectionUtils.isEmpty(result) && result.size() > 5) {
			for (int i = 0; i < result.size(); i++) {
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
			log.info("汇总结果：{}",JsonUtils.obj2JsonString(arr) );
			int h = 1;
			for (String[] strings : arr) {
				int i = 0; //偶数
				int f = 0; //奇数
				int s = 0; //小
				int b = 0; //大
				/**
				 * 单、双判断
				 */
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
						String content = "<div>第"+textno+"期-第"+h+"名:<div>建议买【单】</div>目前【 "+i+" 个双】</div><br/><hr/>";
//						SumDataSendMailConstants.sendEmail(mail,title, content);
//						log.info("邮件已发送");
					}
					if (f >= min) {
						//全是奇数
						String content = "<div>第"+textno+"期-第"+h+"名:<div>建议买【双】</div>目前【 "+f+" 个单】</div><br/><hr/>";
//						SumDataSendMailConstants.sendEmail(mail,title, content);
//						log.info("邮件已发送");
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
						String content = "<div>第"+textno+"期-第"+h+"名:<div>建议买【大】</div>目前【 "+s+" 个小】</div><br/><hr/>";
//						SumDataSendMailConstants.sendEmail(mail,title, content);
//						log.info("邮件已发送");
					} 
					if (b >= min) {
						//全是大
						String content = "<div>第"+textno+"期-第"+h+"名:<div>建议买【小】</div>目前【 "+b+" 个大】</div><br/><hr/>";
//						SumDataSendMailConstants.sendEmail(mail,title, content);
//						log.info("邮件已发送");
					}
				}
				h++;
			}
		}
	}
	
	
	@Test
	public void sumNumsTest() throws IllegalAccessException {
		service.sumNums(null);
	}
	
}
