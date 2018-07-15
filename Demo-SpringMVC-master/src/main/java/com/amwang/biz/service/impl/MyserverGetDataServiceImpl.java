package com.amwang.biz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amwang.biz.serverModel.dao.TbeisaiDataDao;
import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.biz.service.MyserverGetDataService;
import com.amwang.common.utils.JsonUtils;
import com.amwang.utils.DateUtil;

@Service
public class MyserverGetDataServiceImpl implements MyserverGetDataService {
	
	protected transient Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TbeisaiDataDao tbeisaiDataDao;
	
	public int addRecord(TbeisaiData record) {
		log.info("新增数据开始>>>>>>start："+JsonUtils.obj2JsonString(record));
		String textno = record.getTextno();
		int result = 0;
		if (textno.length() == 1) {
			log.info("textno******before:{}",textno);
			String no = tbeisaiDataDao.queryMaxTextno();
			textno = String.valueOf(Integer.valueOf(no)+1);
			log.info("textno******after:{}",textno);
		}
		int count = tbeisaiDataDao.queryRecordByTextNo(textno);
		if (count == 0) {
			record.setCreateTime(DateUtil.getCurrentTimeStamp());
			result = tbeisaiDataDao.addRecord(record);
		}
		log.info("新增数据结束>>>>>>end：新增数量"+JsonUtils.obj2JsonString(result));
		return result;
	}

}
