package com.amwang.utils;

import java.math.BigDecimal;
import java.util.List;

/**
 * 百度echarts工具类
 * @author wangyao.m
 *
 */
public class Series {

	public String name;

	public String type;

	public List<BigDecimal> data;

	public Series(String name, String type, List<BigDecimal> data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}
}
