package com.amwang.biz.job;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amwang.biz.myserverGetData.GetDataFromBeisai;
import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.biz.service.MyserverGetDataService;
import com.amwang.utils.DateUtil;
import com.amwang.utils.JsonUtils;

@Component
public class ScheduleJob {
	
	protected transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MyserverGetDataService getDataService;

	@Scheduled(cron = "0 3/5 9-23,0 * * ?")
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
		getDataService.sumNums(queryDate);
		log.info("统计概率结束>>>>>{}",DateUtil.getCurrentTimeStamp());
	}
	
	@Scheduled(cron = "0 0 1 * * ?")
	public void updData() {
		log.info("更新sum字段开始：{}",DateUtil.getCurrentTimeStamp());
		int count = getDataService.updRecord();
		log.info("更新sum结束：,{},本次更新 {} 条",DateUtil.getCurrentTimeStamp(),count);
	}
	
}
