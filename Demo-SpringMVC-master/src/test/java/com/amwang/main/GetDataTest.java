package com.amwang.main;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.serverModel.dao.TbeisaiDataDao;
import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.biz.service.MyserverGetDataService;
import com.amwang.utils.DateUtil;
import com.amwang.utils.JsonUtils;

public class GetDataTest extends AbstractSpringContextTestSupport {

	@Autowired
	private MyserverGetDataService service;
	
	@Autowired
	private TbeisaiDataDao dao;
	
	@Test
	public void testquerySum() {
		String queryDate = DateUtil.getCurrentDate();
		service.sumNums("2018-07-18");
	}
	
	@Test
	public void insertTest() {
		TbeisaiData record = new TbeisaiData();
		record.setTextno("123");
		record.setOpendate("2018-07-19");
		service.addRecord(record);
		
		List<TbeisaiData> result = dao.sumNums("2018-07-19");
		System.out.println(JsonUtils.list2JsonString(result));
	}
}
