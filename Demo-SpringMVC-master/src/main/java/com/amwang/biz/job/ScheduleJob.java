package com.amwang.biz.job;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amwang.biz.myserverGetData.GetDataFromBeisai;
import com.amwang.biz.myserverGetData.GetDataFromPkHistory;
import com.amwang.biz.serverModel.dao.TgetdataConfigDao;
import com.amwang.biz.serverModel.entity.TPkHisManual;
import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.biz.serverModel.entity.TgetdataConfig;
import com.amwang.biz.service.MyserverGetDataService;
import com.amwang.biz.service.PkHisManualService;
import com.amwang.common.SumDataSendMailConstants;
import com.amwang.utils.DateUtil;
import com.amwang.utils.JsonUtils;

/**
 * 定时任务
 * @author wangyao.m
 *
 */
@Component
public class ScheduleJob {
	
	protected transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MyserverGetDataService getDataService;
	@Autowired
	private PkHisManualService hisManualService;
	@Autowired
	private TgetdataConfigDao configDao;
	
	@Scheduled(cron = "15 3/5 9-23,0 * * ?")
	public void getData() throws IOException{
		log.info("爬取数据开始时间："+DateUtil.getCurrentTimeStamp());
		TbeisaiData data = GetDataFromBeisai.getUrlInfo("http://kj.13322.com/pk10_history_dtoday.html");
		log.info("请求service数据：{}"+JsonUtils.obj2JsonString(data));
		if (null != data) {
			getDataService.addRecord(data);
		} else {
			log.info("本次无更新：{}",DateUtil.getCurrentTimeStamp());
		}
		log.info("爬取数据结束时间："+DateUtil.getCurrentTimeStamp());
		
		log.info("统计概率开始>>>>>{}",DateUtil.getCurrentTimeStamp());
		String queryDate = DateUtil.getCurrentDate();
		try {
			getDataService.sumNums(queryDate);
		} catch (IllegalAccessException e) {
			log.error("概率统计异常：{}",e.getMessage());
		}
		log.info("统计概率结束>>>>>{}",DateUtil.getCurrentTimeStamp());
		
		log.info("统计每条大小单双开始>>>>>{}",DateUtil.getCurrentTimeStamp());
		getDataService.sumBSDS();
		log.info("统计每条大小单双结束>>>>>{}",DateUtil.getCurrentTimeStamp());
		
	}
	
	@Scheduled(cron = "0 0 1 * * ?")
	public void updData() {
		log.info("更新sum字段开始：{}",DateUtil.getCurrentTimeStamp());
		int count = getDataService.updRecord();
		log.info("更新sum结束：,{},本次更新 {} 条",DateUtil.getCurrentTimeStamp(),count);
	}
	
	@Scheduled(cron = "18 3/5 9-23,0 * * ?")
	public void addDoctorCai() {
		log.info("爬取彩专家开始时间："+DateUtil.getCurrentTimeStamp());
		TgetdataConfig config = configDao.getConfig("t2");
		TPkHisManual result = GetDataFromPkHistory.getDataFromPkHistory("http://www.100585.cn/pkhistory.php");
		if (null != result) {
			hisManualService.addRecord(result);
		}
		List<TPkHisManual> resultlist = hisManualService.queryList();
		String con1 = resultlist.get(0).getContent();
		boolean content1 = con1.contains("挂");
		if (content1) {
			String content ="当前时间："+ DateUtil.getCurrentTimeStamp() +"</br><div>彩专家</div>,第"+con1.substring(0, 15)+":挂";
			//邮件通知
			SumDataSendMailConstants.sendEmail(config.getMailTo(), config.getMailTitle(), content, config.getMailSubject());
		}
		log.info("爬取彩专家结束：{}"+JsonUtils.obj2JsonString(DateUtil.getCurrentTimeStamp()));
	}
}
