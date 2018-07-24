package com.amwang.biz.serverModel.dao;

import org.apache.ibatis.annotations.Param;

public interface TSumResultMapper {

	int queryByTextno(@Param("textNo")String textNo);
}