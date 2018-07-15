package com.amwang.main;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.job.ScheduleJob;
import com.amwang.biz.serverModel.dao.TbeisaiDataDao;
import com.amwang.biz.service.MyserverGetDataService;

public class ScheduleTest extends AbstractSpringContextTestSupport {

	@Autowired
	private MyserverGetDataService service;
	@Autowired
	private ScheduleJob schedulejob;
	@Autowired
	private TbeisaiDataDao dao;
	@Test
	public void testGetData() throws IOException{
		schedulejob.getData();
	}
	
}
