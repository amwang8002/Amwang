package com.amwang.biz.serverModel.dao;

import org.apache.ibatis.annotations.Param;

import com.amwang.biz.serverModel.entity.TgetdataConfig;

public interface TgetdataConfigDao {

	TgetdataConfig getConfig(@Param("type")String type);
	
}
