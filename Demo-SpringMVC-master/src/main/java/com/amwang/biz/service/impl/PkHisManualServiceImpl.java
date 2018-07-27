package com.amwang.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amwang.biz.serverModel.dao.TPkHisManualMapper;
import com.amwang.biz.serverModel.entity.TPkHisManual;
import com.amwang.biz.service.PkHisManualService;
import com.amwang.utils.DateUtil;

/**
 * pk10计划服务类
 * @author wangyao.m
 *
 */
@Service
public class PkHisManualServiceImpl implements PkHisManualService {

	@Autowired
	private TPkHisManualMapper pkHisManualMapper;
	
	
	public int addRecord(TPkHisManual record) {
		int addResult = 0;
		int result = pkHisManualMapper.queryByContent(record.getContent());
		if (result == 0) {
			record.setCreateTime(DateUtil.getCurrentTimeStamp());
			addResult = pkHisManualMapper.insertSelective(record);
		}
		return addResult;
	}


	public List<TPkHisManual> queryList() {
		
		return pkHisManualMapper.queryList();
	}

	
}
