package com.amwang.biz.service;

import java.util.List;

import com.amwang.biz.serverModel.entity.TDataUnterruptedCounts;

/**
 * 汇总每个名次的结果数量
 * @author wangyao.m
 *
 */
public interface SumEveryDataCountsService {

	List<TDataUnterruptedCounts> queryByCondition();
}
