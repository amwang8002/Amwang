package com.amwang.biz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amwang.biz.serverModel.dao.TSumResultMapper;
import com.amwang.biz.serverModel.entity.TDataUnterruptedCounts;
import com.amwang.biz.serverModel.entity.TSumResult;
import com.amwang.biz.service.SumEveryDataCountsService;

/**
 * 汇总每个结果数量实现类
 * @author wangyao.m
 *
 */
@Service
public class SumEveryDataCountsServiceImpl implements SumEveryDataCountsService {

	@Autowired
	private TSumResultMapper sumResultMapper;
	
	public List<TDataUnterruptedCounts> queryByCondition() {
		List<TDataUnterruptedCounts> resutList = new ArrayList<TDataUnterruptedCounts>();
		TDataUnterruptedCounts resultCounts = new TDataUnterruptedCounts();
		int firbcount = 0;
		int LS4firbig = 0;
		int LS3firbig = 0;
		List<TSumResult> results = sumResultMapper.queryByCondition();
		//遍历结果集
		for (int i=0 ;i<results.size();i++) {
			TSumResult tSumResult = results.get(i);
			
			String firstBig = tSumResult.getFirstBig();
			if (!StringUtils.isEmpty(firstBig)) {
				firbcount++;
			} else {
				firbcount = 0;  // 为空，归0
			}
			
			if (firbcount == 3 && StringUtils.isEmpty(results.get(i+1).getFirstBig())) {  //LS 4 count
				// 连续次数+1
				LS3firbig++;
			}
			if (firbcount == 4 && StringUtils.isEmpty(results.get(i+1).getFirstBig())) {  //LS 4 count
				// 连续次数+1
				LS4firbig++;
			}
		}
		resultCounts.setPosition("FIRST");
		resultCounts.setType("BIG");
		resultCounts.setNum3(LS3firbig);
		resultCounts.setNum4(LS4firbig);
		resutList.add(resultCounts);
		return resutList;
	}

}
