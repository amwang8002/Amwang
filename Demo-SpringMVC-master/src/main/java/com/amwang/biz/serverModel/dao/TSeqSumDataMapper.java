package com.amwang.biz.serverModel.dao;

import org.apache.ibatis.annotations.Param;

import com.amwang.biz.serverModel.entity.TSeqSumData;

public interface TSeqSumDataMapper {
    int insert(TSeqSumData record);

    int insertSelective(TSeqSumData record);
    
    int queryByCondition(TSeqSumData record);
    
    void callProcedureOfDataSum(@Param("textNo")String textNo);
    
    void callProcedureOfDataSumTest(@Param("textNo")String textNo);
}	