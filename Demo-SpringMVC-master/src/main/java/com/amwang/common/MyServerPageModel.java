package com.amwang.common;

import java.math.BigDecimal;
import java.util.List;

import com.amwang.biz.serverModel.entity.SumEachNum;

public class MyServerPageModel {

	List<SumEachNum> sumEachNums;
	
	BigDecimal count;

	public List<SumEachNum> getSumEachNums() {
		return sumEachNums;
	}

	public void setSumEachNums(List<SumEachNum> sumEachNums) {
		this.sumEachNums = sumEachNums;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}
}