package com.amwang.biz.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.amwang.biz.serverModel.dao.TSeqSumDataMapper;
import com.amwang.biz.serverModel.dao.TbeisaiDataDao;
import com.amwang.biz.serverModel.dao.TgetdataConfigDao;
import com.amwang.biz.serverModel.entity.SumEachNum;
import com.amwang.biz.serverModel.entity.TSeqSumData;
import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.biz.serverModel.entity.TgetdataConfig;
import com.amwang.biz.service.MyserverGetDataService;
import com.amwang.common.LogBase;
import com.amwang.common.MyServerPageModel;
import com.amwang.common.SumDataSendMailConstants;
import com.amwang.utils.DateUtil;
import com.amwang.utils.JsonUtils;

@Service
public class MyserverGetDataServiceImpl extends LogBase implements MyserverGetDataService {
	

	@Autowired
	private TbeisaiDataDao tbeisaiDataDao;
	@Autowired
	private TgetdataConfigDao configDao;
	@Autowired
	private TSeqSumDataMapper sumDataMapper;
	
	private String big = "big";
	private String small = "small";
	private String single = "single";
	private String dou = "dou";
	
	public int addRecord(TbeisaiData record) {
		getLogger().info("新增数据开始>>>>>>start："+JsonUtils.obj2JsonString(record));
		String textno = record.getTextno();
		int result = 0;
		if (textno.length() == 1) {
			getLogger().info("textno******before:{}",textno);
			String no = tbeisaiDataDao.queryMaxTextno();
			textno = String.valueOf(Integer.valueOf(no)+1);
			getLogger().info("textno******after:{}",textno);
		}
		int count = tbeisaiDataDao.queryRecordByTextNo(textno);
		if (count == 0) {
			record.setCreateTime(DateUtil.getCurrentTimeStamp());
			result = tbeisaiDataDao.addRecord(record);
		}
		getLogger().info("新增数据结束>>>>>>end：新增数量"+JsonUtils.obj2JsonString(result));
		return result;
	}

	
	public MyServerPageModel sumEachNum() {
		MyServerPageModel pageModel = new MyServerPageModel();
		getLogger().info("汇总数字1>>>>>>start");
		BigDecimal multi = new BigDecimal(100);
		BigDecimal counts = tbeisaiDataDao.sumAllCounts();
		getLogger().info("查询总记录数:{}",counts);
		List<SumEachNum> result = tbeisaiDataDao.sumEachNum();
		for (SumEachNum sumEachNum : result) {
			BigDecimal con = sumEachNum.getCon();
			if (con != null) {
				sumEachNum.setRate(con.divide(counts,2,BigDecimal.ROUND_HALF_UP).multiply(multi));
			}
		}
		pageModel.setCount(counts);
		pageModel.setSumEachNums(result);
		
		return pageModel;
		
	}


	public int updRecord() {
		getLogger().info("查询sum为空记录开始>>>>>>start:{}",DateUtil.getCurrentTimeStamp());
		List<TbeisaiData> result = tbeisaiDataDao.queryBySum();
		getLogger().info("查询sum为空记录条数：{}",result.size());
		int count = 0;
		if (!CollectionUtils.isEmpty(result)) {
			for (TbeisaiData tbeisaiData : result) {
				int num1 = Integer.valueOf(tbeisaiData.getNum1());
				int num2 = Integer.valueOf(tbeisaiData.getNum2());
				num1 = num1 == 0 ? 10 : num1;
				num2 = num2 == 0 ? 10 : num2;
				int sum = num1 + num2;
				if (sum%2 == 0) {
					tbeisaiData.setSingleOrDouble("双");
				} else {
					tbeisaiData.setSingleOrDouble("单");
				}
				if (sum > 11) {
					tbeisaiData.setBigOrSmall("大");
				} else {
					tbeisaiData.setBigOrSmall("小");
				}
				tbeisaiData.setSum(String.valueOf(sum));
				int i = tbeisaiDataDao.updateRecord(tbeisaiData);
				count += i;
			}
			getLogger().info("sum记录数更新条数：{}",count);
		}
		return count;
	}


	/**
	 * 汇总每个名次
	 * @throws IllegalAccessException 
	 */
	public void sumNums(String queryDate) throws IllegalAccessException {
		getLogger().info("查询汇总配置开始：{}",DateUtil.getCurrentTimeStamp());
		TgetdataConfig config = configDao.getConfig();
		if (null == config) {
			throw new IllegalAccessException("邮件配置计划为空");
		}
		int min = config.getMaxTime();
		String mail = config.getMailTo();
		String title = config.getMailTitle();
		String subject = config.getMailSubject();
		getLogger().info("查询结果：{}",JsonUtils.obj2JsonString(config));
		
		
		getLogger().info("汇总每个名次开始:");
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
			getLogger().info("汇总结果：{}",JsonUtils.obj2JsonString(arr) );
			int h = 1;
			StringBuffer sb = new StringBuffer();
			for (String[] strings : arr) {
				/**
				 * 单、双判断
				 */
				checkSingleOrDouble(strings,textno,h,min,sb);
				
				/**
				 * 大小判断
				 */
				checkBigOrSmall(strings,textno,h,min,sb);
				
				h++;
			}
			if (!StringUtils.isEmpty(sb.toString())) {
				SumDataSendMailConstants.sendEmail(mail,title, sb.toString(),subject);
				getLogger().info("邮件已发送>>>>>>content:{}",sb.toString());
			}
		}
		
	}
	
	/**
	 * 大小单双汇总
	 */
	public void sumBSDS() {
		//查询所有记录
		List<TbeisaiData> result = tbeisaiDataDao.queryList();
		if (!CollectionUtils.isEmpty(result)) {
			for (TbeisaiData record : result) {
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
			}
			
			//调用存储过程更新汇总表
			sumDataMapper.callProcedureOfDataSum();
		}
	}
	
	private void addSumRecord(String textNo,String num,String seq) {
		TSeqSumData record = new TSeqSumData();
		record.setTextNo(textNo);
		record.setSeq(seq);
		record.setValue(num);
		int result = sumDataMapper.queryByCondition(record);
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
			sumDataMapper.insertSelective(record);
		}
	}
	
	
	/**
	 * 单双判断
	 * @param strings 名称数组
	 * @param textno 期数
	 * @param min 最小触发次数
	 * @param sb 邮件内容
	 * @param h 名次
	 * @return
	 */
	private StringBuffer checkSingleOrDouble(String[] strings,String textno,int h,int min,StringBuffer sb) {
		int i = 0; //偶数
		int f = 0; //奇数
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
				String content = "<div>第"+textno+"期-第"+h+"名:建议买【单】</div>目前【 "+i+" 个双】</div><br/><hr/>";
				getLogger().info(">>>>>>begin send email,期数:{},个数{},内容{}",textno,i,content);
				sb.append(content);
			}
			if (f >= min) {
				//全是奇数
				String content = "<div>第"+textno+"期-第"+h+"名:建议买【双】</div>目前【 "+f+" 个单】</div><br/><hr/>";
				getLogger().info(">>>>>>begin send email,期数:{},个数{},内容{}",textno,f,content);
				sb.append(content);
			}
		}
		return sb;
	}
	
	private StringBuffer checkBigOrSmall(String[] strings,String textno,int h,int min,StringBuffer sb) {
		int s = 0; //小
		int b = 0; //大
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
				getLogger().info(">>>>>>begin send email,期数:{},个数{},内容{}",textno,s,content);
				sb.append(content);
			} 
			if (b >= min) {
				//全是大
				String content = "<div>第"+textno+"期-第"+h+"名:建议买【小】</div>目前【 "+b+" 个大】</div><br/><hr/>";
				getLogger().info(">>>>>>begin send email,期数:{},个数{},内容{}",textno,b,content);
				sb.append(content);
			}
		}
		return sb;
	}


}
