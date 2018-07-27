package com.amwang.biz.serverModel.dao;

import com.amwang.biz.serverModel.entity.TSeqSumData;

public interface TSeqSumDataMapper {
    int insert(TSeqSumData record);

    int insertSelective(TSeqSumData record);
    
    int queryByCondition(TSeqSumData record);
    
    void callProcedureOfDataSum();
    
    void callProcedureOfDataSumTest();
}	