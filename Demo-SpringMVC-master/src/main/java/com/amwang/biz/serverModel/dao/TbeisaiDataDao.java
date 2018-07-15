package com.amwang.biz.serverModel.dao;

import org.apache.ibatis.annotations.Param;

import com.amwang.biz.serverModel.entity.TbeisaiData;

public interface TbeisaiDataDao {

	int addRecord(TbeisaiData record);
	
	int queryRecordByTextNo(@Param("textno")String textno);
	
	String queryMaxTextno();
}
