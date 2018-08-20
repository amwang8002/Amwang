package com.amwang.biz.serverModel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amwang.biz.serverModel.entity.TSumResult;

public interface TSumResultMapper {

	int queryByTextno(@Param("textNo")String textNo);
	
	List<TSumResult> queryByOpenDate(@Param("openDate")String openDate);
}