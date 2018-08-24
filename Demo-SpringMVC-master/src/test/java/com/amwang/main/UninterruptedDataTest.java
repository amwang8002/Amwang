package com.amwang.main;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.serverModel.entity.TDataUnterruptedCounts;
import com.amwang.biz.service.SumEveryDataCountsService;
import com.amwang.utils.JsonUtils;

public class UninterruptedDataTest extends AbstractSpringContextTestSupport {

	@Autowired
	private SumEveryDataCountsService sumEveryDataCountsService;
	
	@Test
	public void unterruptedDataTest() {
		List<TDataUnterruptedCounts> result = sumEveryDataCountsService.queryByCondition();
		System.err.println(JsonUtils.list2JsonString(result));
	}
	
	@Test
	public void testArray() {
		String seqs = "1,2,3,4,5,3,2,1,3";
		String[] test = {"1","2","2","3"};
		System.out.println(JsonUtils.obj2JsonString(test));
		System.out.println(test);
	}
}
