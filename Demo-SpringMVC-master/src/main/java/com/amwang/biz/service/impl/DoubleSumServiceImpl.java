package com.amwang.biz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amwang.biz.serverModel.dao.DoubleSumResultMapper;
import com.amwang.biz.serverModel.dao.TbeisaiDataDao;
import com.amwang.biz.serverModel.entity.DoubleSumResult;
import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.biz.service.DoubleSumService;
import com.amwang.common.LogBase;
import com.amwang.utils.JsonUtils;

/**
 * 对子统计服务实现类
 * @author wangyao.m
 *
 */
@Service
public class DoubleSumServiceImpl extends LogBase implements DoubleSumService {

	@Autowired 
	private TbeisaiDataDao tbeisaiDataDao;
	@Autowired
	private DoubleSumResultMapper doubleSumResultDao;
	
	private String D = "D"; // 对子
	private String F = "F"; // 非
	
	
	public void insertDoubleSumResult() {
		getLogger().info("对子统计开始-start>>>>>>");
		DoubleSumResult doubleSumResult = new DoubleSumResult();
		List<TbeisaiData> result = tbeisaiDataDao.sumNums(2);
		getLogger().info("最新两条结果:{}",JsonUtils.list2JsonString(result));
		TbeisaiData data1 = result.get(0);
		TbeisaiData data2 = result.get(1);
		
		DoubleSumResult recordResult = doubleSumResultDao.selectByTextid(data1.getTextno());
		if (null == recordResult) {
			doubleSumResult.setTextId(data1.getTextno());
			if (data1.getNum1().equals(data2.getNum1())) {
				doubleSumResult.setArea1(D);
			} else {
				doubleSumResult.setArea1(F);
			}
			if (data1.getNum2().equals(data2.getNum2())) {
				doubleSumResult.setArea2(D);
			} else {
				doubleSumResult.setArea2(F);
			}
			if (data1.getNum3().equals(data2.getNum3())) {
				doubleSumResult.setArea3(D);
			} else {
				doubleSumResult.setArea3(F);
			}
			if (data1.getNum4().equals(data2.getNum4())) {
				doubleSumResult.setArea4(D);
			} else {
				doubleSumResult.setArea4(F);
			}
			if (data1.getNum5().equals(data2.getNum5())) {
				doubleSumResult.setArea5(D);
			} else {
				doubleSumResult.setArea5(F);
			}
			if (data1.getNum6().equals(data2.getNum6())) {
				doubleSumResult.setArea6(D);
			} else {
				doubleSumResult.setArea6(F);
			}
			if (data1.getNum7().equals(data2.getNum7())) {
				doubleSumResult.setArea7(D);
			} else {
				doubleSumResult.setArea7(F);
			}
			if (data1.getNum8().equals(data2.getNum8())) {
				doubleSumResult.setArea8(D);
			} else {
				doubleSumResult.setArea8(F);
			}
			if (data1.getNum9().equals(data2.getNum9())) {
				doubleSumResult.setArea9(D);
			} else {
				doubleSumResult.setArea9(F);
			}
			if (data1.getNum10().equals(data2.getNum10())) {
				doubleSumResult.setArea10(D);
			} else {
				doubleSumResult.setArea10(F);
			}
			
			doubleSumResult.setGmtCreate(new Date());
			doubleSumResult.setGmtModified(new Date());
			doubleSumResultDao.insertSelective(doubleSumResult);
		} else {
			getLogger().info("{}该记录已存在",data1.getTextno());
		}
	}

}
