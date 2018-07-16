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
import com.amwang.common.utils.JsonUtils;
import com.amwang.utils.DateUtil;

@Component
public class ScheduleJob {
	
	protected transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MyserverGetDataService getDataService;

	@Scheduled(cron = "* 0/1 * * * ?}")
	public void getData() throws IOException{
		log.info("爬取数据开始时间："+DateUtil.getCurrentTimeStamp());
		TbeisaiData data = GetDataFromBeisai.getUrlInfo("http://kj.13322.com/pk10_history_dtoday.html");
		log.info("请求service数据："+JsonUtils.obj2JsonString(data));
		getDataService.addRecord(data);
		log.info("爬取数据结束时间："+DateUtil.getCurrentTimeStamp());
	}
	
}
