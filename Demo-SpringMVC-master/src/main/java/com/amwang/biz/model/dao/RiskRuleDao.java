/**
 * Copyright 2016 by IPS. Floor 3,Universal Industrial Building, 
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.amwang.biz.model.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amwang.biz.model.entity.RiskRule;
import com.amwang.biz.model.entity.RiskRuleParam;
import com.amwang.biz.model.entity.RiskRulePrdCfg;

/**
 * @Description: 风险规则数据访问接口
 * @author niko wang
 * @version 1.0 2016年3月28日
 */
public interface RiskRuleDao {

	/**
	 * 查询风险规则信息列表
	 * 
	 * @return 风险规则信息列表
	 */
	//public List<RiskRule> queryRiskRule (@Param("pageable") Pageable pageable, @Param("riskRule") RiskRule riskRule);

	/**
	 * 查询风险规则信息数量
	 * 
	 * @return 风险规则信息数量
	 */
	public int queryRiskRuleCount(@Param("riskRule") RiskRule riskRule);

	/**
	 * 查询风险规则参数信息
	 * @param riskRuleId
	 * @return
	 */
	public List<RiskRuleParam> queryRiskRuleParam(@Param("riskRuleId") BigDecimal riskRuleId);

	/**
	 * 查询风险规则基础产品配置信息
	 * @param riskRuleId
	 * @return
	 */
	public List<RiskRulePrdCfg> queryRiskRulePrdCfg(@Param("riskRuleId") BigDecimal riskRuleId);
	/**
	 * 根据风控规则ID查询风控规则信息
	 * @param riskRuleId
	 * @return
	 */
	RiskRule selectByRiskRuleId(@Param("riskRuleId") Long riskRuleId);
	/**
	 * 风控规则有效性变更
	 * @param riskRule
	 */
	void updRiskRuleStatus(RiskRule riskRule);
}
