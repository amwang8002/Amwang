package com.amwang.biz.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.amwang.biz.serverModel.dao.TbeisaiDataDao;
import com.amwang.biz.serverModel.entity.SumEachNum;
import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.biz.service.MyserverGetDataService;
import com.amwang.common.MyServerPageModel;
import com.amwang.common.utils.JsonUtils;
import com.amwang.utils.DateUtil;

@Service
public class MyserverGetDataServiceImpl implements MyserverGetDataService {
	
	protected transient Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TbeisaiDataDao tbeisaiDataDao;
	
	public int addRecord(TbeisaiData record) {
		log.info("新增数据开始>>>>>>start："+JsonUtils.obj2JsonString(record));
		String textno = record.getTextno();
		int result = 0;
		if (textno.length() == 1) {
			log.info("textno******before:{}",textno);
			String no = tbeisaiDataDao.queryMaxTextno();
			textno = String.valueOf(Integer.valueOf(no)+1);
			log.info("textno******after:{}",textno);
		}
		int count = tbeisaiDataDao.queryRecordByTextNo(textno);
		if (count == 0) {
			record.setCreateTime(DateUtil.getCurrentTimeStamp());
			result = tbeisaiDataDao.addRecord(record);
		}
		log.info("新增数据结束>>>>>>end：新增数量"+JsonUtils.obj2JsonString(result));
		return result;
	}

	
	public MyServerPageModel sumEachNum() {
		MyServerPageModel pageModel = new MyServerPageModel();
		log.info("汇总数字1>>>>>>start");
		BigDecimal multi = new BigDecimal(100);
		BigDecimal counts = tbeisaiDataDao.sumAllCounts();
		log.info("查询总记录数:{}",counts);
		List<SumEachNum> result = tbeisaiDataDao.sumEachNum();
		for (SumEachNum sumEachNum : result) {
			BigDecimal con = sumEachNum.getCon();
			if (con != null) {
				sumEachNum.setRate(con.divide(counts,2,BigDecimal.ROUND_HALF_UP).multiply(multi));
			}
		}
		pageModel.setCount(counts);
		pageModel.setSumEachNums(result);
		
		return pageModel;
		
	}


	public int updRecord() {
		log.info("查询sum为空记录开始>>>>>>start:{}",DateUtil.getCurrentTimeStamp());
		List<TbeisaiData> result = tbeisaiDataDao.queryBySum();
		log.info("查询sum为空记录条数：{}",result.size());
		int count = 0;
		if (!CollectionUtils.isEmpty(result)) {
			for (TbeisaiData tbeisaiData : result) {
				int num1 = Integer.valueOf(tbeisaiData.getNum1());
				int num2 = Integer.valueOf(tbeisaiData.getNum2());
				num1 = num1 == 0 ? 10 : num1;
				num2 = num2 == 0 ? 10 : num2;
				int sum = num1 + num2;
				if (sum%2 == 0) {
					tbeisaiData.setSingleOrDouble("双");
				} else {
					tbeisaiData.setSingleOrDouble("单");
				}
				if (sum > 11) {
					tbeisaiData.setBigOrSmall("大");
				} else {
					tbeisaiData.setBigOrSmall("小");
				}
				tbeisaiData.setSum(String.valueOf(sum));
				int i = tbeisaiDataDao.updateRecord(tbeisaiData);
				count += i;
			}
			log.info("sum记录数更新条数：{}",count);
		}
		return count;
	}

}
