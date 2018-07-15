package com.amwang.biz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.amwang.biz.model.entity.RiskRule;
import com.amwang.biz.service.RiskRuleService;

@Service
public class RiskRuleServiceImpl implements RiskRuleService {
	
	protected transient Logger log = LoggerFactory.getLogger(this.getClass());
	
//	@Autowired
//	private RiskRuleDao riskRuleDao;

	public RiskRule selectByRiskRuleId(Long riskRuleId) {
		RiskRule ruleInfo  = null;
		log.info("开始查询规则>>>>>>规则编号：{}",riskRuleId);
//		ruleInfo  = riskRuleDao.selectByRiskRuleId(riskRuleId);
//		log.info("规则信息>>>>>>:{}",ruleInfo);
		return ruleInfo;
	}

}
