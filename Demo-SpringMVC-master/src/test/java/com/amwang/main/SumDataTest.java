package com.amwang.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.serverModel.dao.TSeqSumDataMapper;
import com.amwang.biz.serverModel.dao.TSumResultMapper;
import com.amwang.biz.serverModel.dao.TbeisaiDataDao;
import com.amwang.biz.serverModel.entity.TSeqSumData;
import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.biz.service.MyserverGetDataService;
import com.amwang.biz.service.SumEveryDataCountsService;
import com.amwang.utils.DateUtil;
import com.amwang.utils.JsonUtils;

public class SumDataTest extends AbstractSpringContextTestSupport{

	@Autowired
	private MyserverGetDataService service;
	@Autowired
	private SumEveryDataCountsService sumDailyService;
	@Autowired
	private TSeqSumDataMapper sumDataDao;
	@Autowired
	private TSumResultMapper tSumResultMapper;
	@Autowired
	private TbeisaiDataDao tbeisaiDao;
	
	private String big = "big";
	private String small = "small";
	private String single = "single";
	private String dou = "dou";
	
	@Test
	public void callProcTest() {
		sumDataDao.callProcedureOfDataSumTest("696199");
	}
	
	@Test
	public void addSumDataTest() {
		service.sumBSDS();
	}
	
	
	@Test
	public void countTest() {
		TSeqSumData record = new TSeqSumData();
		record.setTextNo("694374");
		record.setSeq("1");
		int result = sumDataDao.queryByCondition(record);
		System.out.println(result);
	}
	
	@Test
	public void testUpdSum() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("shutdown.exe -s -t 40");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 批量循环跑数据
	 * @throws IOException
	 */
	@Test
	public void testDate() {
		String startDate = "2019-07-04";
		String endDate = "2019-05-16";
		String start = startDate;
		int count = 180;
		boolean flag = false;
		while (!startDate.equals(endDate)) {
			try {
				getUrlTestMore(count,startDate,startDate.replaceAll("-", ""));
			} catch (IOException e) {
				flag = true;
			}
			// 每次抽完一天时间等待2秒
			try {
				TimeUnit.SECONDS.sleep(2L);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
			//连接异常重新获取链接
			if (!flag) {
				startDate  = DateUtil.sourcePlusInterval(startDate, -1);
			} else {
				flag = false;
			}
		}
		// 汇总丢失数据
		sumLostRecord(endDate,start);
		
		// 运行结束执行命令
//		Runtime runtime = Runtime.getRuntime();
//		try {
//			runtime.exec("shutdown.exe -s -t 40");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}
	
	private void getUrlTestMore(int count,String date1,String date2) throws IOException {
		String url = "http://kj.13322.com/pk10_history_d"+date2+".html";
		List<TbeisaiData> result = getDataTest(url,count);
		for (TbeisaiData tbeisaiData : result) {
			if (null != tbeisaiData) {
				service.addRecord(tbeisaiData);
			} else {
				log.info("本次无更新：{}",DateUtil.getCurrentTimeStamp());
			}
		}
	}
	/**
	 * 单独跑某一天数据
	 * @throws IOException
	 */
	@Test
	public void getUrlTest() throws IOException {
		int count = 179;
		String queryDate = "2019-02-20";
		List<TbeisaiData> result = getDataTest("http://kj.13322.com/pk10_history_d20190220.html",count);
		for (TbeisaiData tbeisaiData : result) {
			if (null != tbeisaiData) {
				service.addRecord(tbeisaiData);
			} else {
				log.info("本次无更新：{}",DateUtil.getCurrentTimeStamp());
			}
		}
		sumLostRecord(DateUtil.sourcePlusInterval(queryDate, -1), queryDate);
	}
	
	
	private List<TbeisaiData> getDataTest(String httpurl , int count) throws IOException {
		List<TbeisaiData> demos = new ArrayList<TbeisaiData>();
		TbeisaiData demo = null;
		boolean flag = false;
		Document doc = null;
		try {
			log.info("开始请求客户端,请求网址{}",httpurl);
			doc = Jsoup.connect(httpurl)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36")
					.timeout(10000).post();
		} catch (IOException e) {
			log.error("请求失败：{}",e);
			throw new IOException(e);
		}
		log.info("请求内容：{}",doc);
		Elements elements = doc.getElementsByTag("td");// 找到所有a标签
		int num = 0;
		for (Element element : elements) {
			if (!StringUtils.isEmpty(element.text())) {
				log.info("数据信息：{}",element.text());
				String attr = element.text();
				if (attr.contains("-")) {
					if (flag) {
						log.info("数据信息组装完毕： b {}",JsonUtils.obj2JsonString(demo));
						num++;
						demos.add(demo);
						flag = false;
						if (count == num) {
							break;
						}
					} 
					demo = new TbeisaiData();
					demo.setOpendate(attr);
					flag = true;
				}
				if (Pattern.compile("[0-9]*").matcher(attr).matches()) {
					log.info("期数或总和>>>>>>{}",attr);
					if (attr.equals("696098")) {
						log.info("");
					}
					if (attr.length() == 2 || attr.length() == 1) {
						demo.setSum(attr);
						if (Integer.valueOf(attr).compareTo(11) > 0) {
							demo.setBigOrSmall("大");
						} else {
							demo.setBigOrSmall("小");
						}
						if (Integer.valueOf(attr) % 2 == 0) {
							demo.setSingleOrDouble("双");
						} else {
							demo.setSingleOrDouble("单");
						}
					} else if (attr.length() >5) {
						log.info("期数：{}",attr);
						demo.setTextno(attr);
						
					}
				}
			}
			Elements tabname = element.getElementsByTag("span");
			log.info("数据内容：{}",tabname);
			if (tabname.size() == 10) {
				for (int j = 0; j < tabname.size(); j++) {
					String value = tabname.get(j).attr("class");
					if (value.contains("Bwi")) {
						int length = value.length();
						value = value.substring(length-2,length-1);
					}
					if (j == 0) {
						demo.setNum1(value);
					} else if (j == 1) {
						demo.setNum2(value);
					} else if (j == 2) {
						demo.setNum3(value);
					} else if (j == 3) {
						demo.setNum4(value);
					} else if (j == 4) {
						demo.setNum5(value);
					} else if (j == 5) {
						demo.setNum6(value);
					} else if (j == 6) {
						demo.setNum7(value);
					} else if (j == 7) {
						demo.setNum8(value);
					} else if (j == 8) {
						demo.setNum9(value);
					} else if (j == 9) {
						demo.setNum10(value);
					}
				}
			}
		}
		demos.add(demo);
		return demos;
	}
	
	/**
	 * 汇总某一条记录到 t_sum_result表中
	 */
	private void sumLostRecord(String sDate,String eDate) {
		List<String> lostRecords = sumDailyService.queryLostRecord(sDate,eDate);
		sumBDS(lostRecords.size()+1, null, lostRecords);
	}
	
	private void sumBDS(int count,String queredate,List<String> textNos) {
		//查询所有记录
		List<TbeisaiData> result = tbeisaiDao.queryListTest(queredate,textNos);
		int num = 0;
		if (!CollectionUtils.isEmpty(result)) {
			for (TbeisaiData record : result) {
				if (num == count) {
					break;
				}
				String textNo = record.getTextno();
				String num1   = record.getNum1(); 
				addSumRecord(textNo, num1, "1");
				String num2   = record.getNum2(); 
				addSumRecord(textNo, num2, "2");
				String num3   = record.getNum3(); 
				addSumRecord(textNo, num3, "3");
				String num4   = record.getNum4(); 
				addSumRecord(textNo, num4, "4");
				String num5   = record.getNum5(); 
				addSumRecord(textNo, num5, "5");
				String num6   = record.getNum6(); 
				addSumRecord(textNo, num6, "6");
				String num7   = record.getNum7(); 
				addSumRecord(textNo, num7, "7");
				String num8   = record.getNum8(); 
				addSumRecord(textNo, num8, "8");
				String num9   = record.getNum9(); 
				addSumRecord(textNo, num9, "9");
				String num10   = record.getNum10();
				addSumRecord(textNo, num10, "10");
				num++;
				int resu = tSumResultMapper.queryByTextno(textNo);
				if (resu == 0) {
					//调用存储过程更新汇总表
//					getLogger().info("调用存储过程执行每个名次汇总结果开始>>>>>>期数：{}",textNo);
					sumDataDao.callProcedureOfDataSum(textNo);
//					getLogger().info("调用存储过程更新每个名次汇总结果结束>>>>>>期数：{}",textNo);
				}
			}
		}
	}
	
	private void addSumRecord(String textNo,String num,String seq) {
		
		TSeqSumData record = new TSeqSumData();
		record.setTextNo(textNo);
		record.setSeq(seq);
		record.setValue(num);
		int result = sumDataDao.queryByCondition(record);
		if (result == 0) {
			int a = Integer.valueOf(num);
			if (a%2 == 0) {
				record.setDoubles(dou);
			}else {
				record.setSingle(single);
			}
			if (0<a && a<6) {
				record.setSmall(small);
			} else {
				record.setBig(big);
			}
			record.setCreateTime(DateUtil.getCurrentTimeStamp());
			sumDataDao.insertSelective(record);
		}
	}
	
}
