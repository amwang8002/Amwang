package com.amwang.biz.serverModel.dao;

import com.amwang.biz.serverModel.entity.DoubleSumResult;

public interface DoubleSumResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(DoubleSumResult record);

    DoubleSumResult selectByTextid(String textId);

    int updateByPrimaryKeySelective(DoubleSumResult record);

}