package com.amwang.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.dwmodel.dao.SumDwtradeDao;
import com.amwang.biz.dwmodel.entity.DwTrade;
import com.amwang.biz.model.dao.RiskRuleDao;
import com.amwang.biz.model.entity.RiskRule;
import com.amwang.biz.service.SumDwTradeService;
import com.amwang.common.utils.JsonUtils;

public class AAA extends AbstractSpringContextTestSupport {
	
	@Autowired
	private RiskRuleDao riskRuleDao;
	
	@Autowired
	private SumDwtradeDao sumDwTradeDao;
	
	@Autowired
	private SumDwTradeService sumDwTradeService;
	
	@Test
	public void testSum(){
		List<DwTrade> list2 = new ArrayList<DwTrade>();
		List<DwTrade> listresult = sumDwTradeService.sumPrdInfo();
		for (DwTrade dwTrade : listresult) {
			DwTrade dwTrade2 = new DwTrade();
			dwTrade2.setProdCode(dwTrade.getProdCode());
			dwTrade2.setNum(dwTrade.getNum());
			list2.add(dwTrade2);
			System.out.println(JsonUtils.obj2JsonString(dwTrade2));
		}
		System.out.println(JsonUtils.list2JsonString(list2));
//		for (DwTrade dwTrade : listresult) {
//			System.out.println(JsonUtils.obj2JsonString(dwTrade));
//		}
//		
//		List<DwTrade> result = sumDwTradeDao.sumPrdInfo();
//		BigDecimal sum = new BigDecimal(0);
//		for (DwTrade dwTrade : result) {
//			
//			System.out.println(JsonUtils.obj2JsonString(dwTrade));
//			sum = sum.add(dwTrade.getNum());
//			
//		}
//		System.out.println(sum.toString());
	}
	
	@Test
	public void testAAA(){
		RiskRule result = riskRuleDao.selectByRiskRuleId(3L);
		System.out.println(result.getRuleDesc());
	}

}
