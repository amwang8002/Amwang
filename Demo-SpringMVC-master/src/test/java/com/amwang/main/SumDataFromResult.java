package com.amwang.main;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.serverModel.dao.TSumResultMapper;
import com.amwang.biz.serverModel.entity.TSumResult;
import com.amwang.utils.JsonUtils;

public class SumDataFromResult extends AbstractSpringContextTestSupport {
	@Autowired
	private TSumResultMapper tSumResultMapper;
	
	@Test
	public void testresult() {
		List<TSumResult> results = tSumResultMapper.queryByOpenDate("");
		System.out.println(results.size());
		System.err.println(JsonUtils.list2JsonString(results));
	}
}