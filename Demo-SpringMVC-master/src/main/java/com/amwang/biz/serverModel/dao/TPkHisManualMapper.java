package com.amwang.biz.serverModel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amwang.biz.serverModel.entity.TPkHisManual;

public interface TPkHisManualMapper {
    int insert(TPkHisManual record);

    int insertSelective(TPkHisManual record);

    int queryByContent(@Param("content")String content);
    
    List<TPkHisManual> queryList();
}