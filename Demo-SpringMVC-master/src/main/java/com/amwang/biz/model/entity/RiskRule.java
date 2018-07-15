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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Description: 风控规则信息实体类
 * @author Jian Jang
 * @version 1.0 2016年3月18日
 */
public class RiskRule {
	private BigDecimal riskRuleId;

	private String ruleType;

	private String ruleTypeName;

	private String ruleDesc;

	private String handleType;

	private String handleTypeName;

	private String status;

	private String statusName;

	private String prdCfgName;

	private String systemCode;

	private String basicPrdCode;

	private String ruleClass;

	private List<RiskRuleParam> ruleParamList = new ArrayList<RiskRuleParam>();

    private List<RiskRulePrdCfg> rulePrdCfgList = new ArrayList<RiskRulePrdCfg>();

    //临时属性
    private  String tradePara1;
    private  String tradePara2;
    private String tradePara3;
    private String tradePara4;
    private String tradePara5;
    
    private String riskType;
    
	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getTradePara4() {
		return tradePara4;
	}

	public void setTradePara4(String tradePara4) {
		this.tradePara4 = tradePara4;
	}

	public String getTradePara5() {
		return tradePara5;
	}

	public void setTradePara5(String tradePara5) {
		this.tradePara5 = tradePara5;
	}

	public String getTradePara3() {
		return tradePara3;
	}

	public void setTradePara3(String tradePara3) {
		this.tradePara3 = tradePara3;
	}

	public BigDecimal getRiskRuleId() {
		return riskRuleId;
	}

	public void setRiskRuleId(BigDecimal riskRuleId) {
		this.riskRuleId = riskRuleId;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrdCfgName() {
		return prdCfgName;
	}

	public void setPrdCfgName(String prdCfgName) {
		this.prdCfgName = prdCfgName;
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

	public String getRuleClass() {
		return ruleClass;
	}

	public void setRuleClass(String ruleClass) {
		this.ruleClass = ruleClass;
	}

	public String getRuleTypeName() {
		return ruleTypeName;
	}

	public void setRuleTypeName(String ruleTypeName) {
		this.ruleTypeName = ruleTypeName;
	}

	public String getHandleTypeName() {
		return handleTypeName;
	}

	public void setHandleTypeName(String handleTypeName) {
		this.handleTypeName = handleTypeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<RiskRuleParam> getRuleParamList() {
		return ruleParamList;
	}

	public void setRuleParamList(List<RiskRuleParam> ruleParamList) {
		this.ruleParamList = ruleParamList;
	}

	public List<RiskRulePrdCfg> getRulePrdCfgList() {
		return rulePrdCfgList;
	}

	public void setRulePrdCfgList(List<RiskRulePrdCfg> rulePrdCfgList) {
		this.rulePrdCfgList = rulePrdCfgList;
	}

	public String getTradePara1() {
		return tradePara1;
	}

	public void setTradePara1(String tradePara1) {
		this.tradePara1 = tradePara1;
	}

	public String getTradePara2() {
		return tradePara2;
	}

	public void setTradePara2(String tradePara2) {
		this.tradePara2 = tradePara2;
	}

}