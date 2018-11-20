package com.amwang.biz.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amwang.biz.serverModel.entity.TDataUnterruptedCounts;

/**
 * 汇总每个名次的结果数量
 * @author wangyao.m
 *
 */
public interface SumEveryDataCountsService {

	List<TDataUnterruptedCounts> queryByCondition();
	
	List<String> queryLostRecord(String openDate,String endDate);
}
