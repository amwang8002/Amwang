package com.amwang.biz.dwmodel.entity;

import java.math.BigDecimal;

public class DwTrade {

	private String prodCode;
	
	private String basicPrdName;
	
	private BigDecimal num;
	
	private BigDecimal sumCount;

	public BigDecimal getSumCount() {
		return sumCount;
	}

	public void setSumCount(BigDecimal sumCount) {
		this.sumCount = sumCount;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getBasicPrdName() {
		return basicPrdName;
	}

	public void setBasicPrdName(String basicPrdName) {
		this.basicPrdName = basicPrdName;
	}

	public BigDecimal getNum() {
		return num;
	}

	public void setNum(BigDecimal num) {
		this.num = num;
	}
}
