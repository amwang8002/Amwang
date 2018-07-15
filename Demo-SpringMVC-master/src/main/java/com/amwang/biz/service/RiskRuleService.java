package com.amwang.biz.service;

import org.apache.ibatis.annotations.Param;

import com.amwang.biz.model.entity.RiskRule;

public interface RiskRuleService {

	/**
	 * 根据风控规则ID查询风控规则信息
	 * @param riskRuleId
	 * @return
	 */
	RiskRule selectByRiskRuleId(@Param("riskRuleId") Long riskRuleId);
}
