package com.amwang.main;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.serverModel.dao.TSeqSumDataMapper;
import com.amwang.biz.serverModel.entity.TSeqSumData;
import com.amwang.biz.service.MyserverGetDataService;

public class SumDataTest extends AbstractSpringContextTestSupport{

	@Autowired
	private MyserverGetDataService service;
	@Autowired
	private TSeqSumDataMapper sumDataDao;
	
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
}
