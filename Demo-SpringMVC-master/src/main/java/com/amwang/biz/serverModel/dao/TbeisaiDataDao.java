package com.amwang.biz.serverModel.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amwang.biz.serverModel.entity.SumEachNum;
import com.amwang.biz.serverModel.entity.TbeisaiData;

public interface TbeisaiDataDao {

	int addRecord(TbeisaiData record);
	
	int queryRecordByTextNo(@Param("textno")String textno);
	
	String queryMaxTextno();
	
	List<SumEachNum> sumEachNum();
	
	BigDecimal sumAllCounts();
	
	int updateRecord(TbeisaiData record);
	
	List<TbeisaiData> queryBySum();
}
