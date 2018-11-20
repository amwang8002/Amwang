package com.amwang.biz.serverModel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amwang.biz.serverModel.entity.TSumResult;

public interface TSumResultMapper {

	int queryByTextno(@Param("textNo")String textNo);
	
	List<TSumResult> queryByOpenDate(@Param("openDate")String openDate);
	
	List<TSumResult> queryByCondition();
	
	/**
	 * 查询记录中丢失数据
	 * <p>Title: queryLostRecord</p>  
	 * <p>Description: </p>  
	 * @param openDate
	 * @return
	 */
	List<String> queryLostRecord(@Param("startDate")String startDate,@Param("endDate")String endDate);
}