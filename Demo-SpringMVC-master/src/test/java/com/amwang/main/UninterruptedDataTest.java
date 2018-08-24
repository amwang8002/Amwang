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
		int [][] sequences = new int[10][4];
		int [] counts = new int [30];
		
		for (int i = 0; i < 5; i++) {
			sequences[1][1]++;
			sequences[2][1]++;
			
			counts[3]++;
		}
		
		System.out.println(JsonUtils.obj2JsonString(sequences));
		System.out.println(JsonUtils.obj2JsonString(counts).replace("[", "").replace("]", "").replace("\"", ""));
		sequences[1][1] = 0;
		System.out.println(JsonUtils.obj2JsonString(sequences));
	}
}
