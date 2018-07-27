package com.amwang.biz.service;

import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.common.MyServerPageModel;

public interface MyserverGetDataService {

	int addRecord(TbeisaiData record);
	
	MyServerPageModel sumEachNum();
	
	int updRecord();
	
	void sumNums(String queryDate) throws IllegalAccessException;
	
	void sumBSDS();
	
	void pkPlan5in3();
}
