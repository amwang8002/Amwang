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
 * @Description: 风控规则参数信息实体类
 * @author IH13672
 * @version 1.0 2016年3月30日
 */
public class RiskRuleParam {
	private BigDecimal paramId;

	private BigDecimal riskRuleId;

	private String paramName;

	private String paramValue;

	public BigDecimal getParamId() {
		return paramId;
	}

	public void setParamId(BigDecimal paramId) {
		this.paramId = paramId;
	}

	public BigDecimal getRiskRuleId() {
		return riskRuleId;
	}

	public void setRiskRuleId(BigDecimal riskRuleId) {
		this.riskRuleId = riskRuleId;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
}
