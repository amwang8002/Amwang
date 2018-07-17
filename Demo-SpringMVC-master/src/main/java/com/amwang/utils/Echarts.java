package com.amwang.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 百度echarts工具类
 * @author wangyao.m
 *
 */
public class Echarts {
	public List<String> legend = new ArrayList<String>();//数据分组  
    public List<String> category = new ArrayList<String>();//横坐标  
    public List<Series> series = new ArrayList<Series>();//纵坐标  


    public Echarts(List<String> legendList, List<String> categoryList, List<Series> seriesList) {  
        super();  
        this.legend = legendList;  
        this.category = categoryList;  
        this.series = seriesList;  
    }  
}
