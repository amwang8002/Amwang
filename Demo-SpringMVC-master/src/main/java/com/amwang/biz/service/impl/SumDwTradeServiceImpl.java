package com.amwang.biz.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amwang.biz.dwmodel.entity.DwTrade;
import com.amwang.biz.service.SumDwTradeService;

@Service
public class SumDwTradeServiceImpl implements SumDwTradeService {
	
//	@Autowired
//	private SumDwtradeDao sumDwtradeDao;

	public List<DwTrade> sumPrdInfo() {
		// TODO Auto-generated method stub
		List<DwTrade> list = null;
//		list = sumDwtradeDao.sumPrdInfo(); 
		return list;
	}

}
