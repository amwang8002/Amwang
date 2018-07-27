package com.amwang.biz.service;

import java.util.List;

import com.amwang.biz.serverModel.entity.TPkHisManual;

public interface PkHisManualService {

	int addRecord(TPkHisManual record);
	
	List<TPkHisManual> queryList();
}
