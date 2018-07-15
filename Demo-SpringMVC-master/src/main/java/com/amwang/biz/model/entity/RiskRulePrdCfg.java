/**
 * Copyright 2016 by IPS. Floor 3,Universal Industrial Building, 
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.amwang.biz.model.entity;

import java.math.BigDecimal;

/**
 * @Description: 风控规则产品配置信息实体类
 * @author IH13672
 * @version 1.0 2016年3月30日
 */
public class RiskRulePrdCfg {
	private BigDecimal cfgId;

	private BigDecimal riskRuleId;

	private String systemCode;

	private String basicPrdCode;

	private String systemName;

	private String basicPrdName;

	public BigDecimal getCfgId() {
		return cfgId;
	}

	public void setCfgId(BigDecimal cfgId) {
		this.cfgId = cfgId;
	}

	public BigDecimal getRiskRuleId() {
		return riskRuleId;
	}

	public void setRiskRuleId(BigDecimal riskRuleId) {
		this.riskRuleId = riskRuleId;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getBasicPrdCode() {
		return basicPrdCode;
	}

	public void setBasicPrdCode(String basicPrdCode) {
		this.basicPrdCode = basicPrdCode;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getBasicPrdName() {
		return basicPrdName;
	}

	public void setBasicPrdName(String basicPrdName) {
		this.basicPrdName = basicPrdName;
	}
}
