package com.amwang.main;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.serverModel.dao.TSumResultMapper;
import com.amwang.biz.serverModel.entity.TDataUnterruptedCounts;
import com.amwang.biz.serverModel.entity.TSumResult;
import com.amwang.biz.service.SumEveryDataCountsService;
import com.amwang.utils.JsonUtils;

public class SumDataFromResult extends AbstractSpringContextTestSupport {
	@Autowired
	private TSumResultMapper tSumResultMapper;
	@Autowired
	private SumEveryDataCountsService sumDailyService;
	
	@Test
	public void testresult() {
		List<TSumResult> results = tSumResultMapper.queryByOpenDate("2018-10-09");
		System.out.println(results.size());
		System.out.println(JsonUtils.list2JsonString(results));
	}
	
	@Test
	public void testSumData() {
		List<TDataUnterruptedCounts> result = sumDailyService.queryByCondition();
		System.out.println(JsonUtils.list2JsonString(result));
	}
}
