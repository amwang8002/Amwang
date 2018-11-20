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
		int [][] sequences = new int[10][4];  // [a][b] a:名次，b:大小单双
		int [] counts = new int [30]; // [i] i的位置为连续次数，值为连续次数的次数
		List<TSumResult> results = sumResultMapper.queryByCondition();
		//遍历结果集
		for (int i=0 ;i<results.size();i++) {
			TSumResult tSumResult2 = null;
			TSumResult tSumResult = results.get(i);
			if (i != results.size()-1) {
				tSumResult2 = results.get(i+1);
			}
			
			String firstBig = tSumResult.getFirstBig();
			String firstSam = tSumResult.getFirstSmall();
			if (!StringUtils.isEmpty(firstBig)) {
				sequences[0][0]++; //冠军-大 的次数递增
			} else {
				sequences[0][0] = 0;  // 为空，归0
			}
			
			if (sequences[0][0] == 3 && (i == results.size()-1 || StringUtils.isEmpty(tSumResult2.getFirstBig()))) {  //LS 3 count
				// 连续次数+1
				counts[2]++;
			}
			if (sequences[0][0] == 4 && (i == results.size()-1 || StringUtils.isEmpty(tSumResult2.getFirstBig()))) {  //LS 4 count
				// 连续次数+1
				counts[3]++;
			}
		}
		resultCounts.setPosition("FIRST");
		resultCounts.setType("BIG");
		resutList.add(resultCounts);
		return resutList;
	}

	/**
	 * 查询统计记录中丢失数据
	 * <p>Title: queryLostRecord</p>  
	 * <p>Description: </p>  
	 * @param openDate
	 * @return  
	 */
	public List<String> queryLostRecord(String openDate,String endDate) {
		return sumResultMapper.queryLostRecord(openDate,endDate);
	}

}
