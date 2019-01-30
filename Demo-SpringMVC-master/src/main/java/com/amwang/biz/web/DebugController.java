package com.amwang.biz.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amwang.biz.serverModel.entity.SumEachNum;
import com.amwang.biz.service.MyserverGetDataService;
import com.amwang.common.LogBase;
import com.amwang.common.MyServerPageModel;
import com.amwang.utils.DateUtil;
import com.amwang.utils.Echarts;
import com.amwang.utils.JsonUtils;
import com.amwang.utils.Series;

@Controller
@RequestMapping
public class DebugController extends LogBase {

	@Autowired
	private MyserverGetDataService dataService;
	
	@RequestMapping(value = "/ab.htm",method={RequestMethod.POST,RequestMethod.GET},produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String requestAjax(HttpServletRequest request,HttpServletResponse response) {
		MyServerPageModel pageModel = dataService.sumEachNum();
		List<SumEachNum> result = pageModel.getSumEachNums();
		List<String> category = new ArrayList<String>();
		List<BigDecimal> index = new ArrayList<BigDecimal>();
		
		for (SumEachNum sumEachNum : result) {
			category.add(sumEachNum.getNum());
			index.add(sumEachNum.getRate());
		}
		List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"出现概率"}));//数据分组
		List<Series> series = new ArrayList<Series>();
		series.add(new Series("出现概率", "bar", index));
		Echarts echarts = new Echarts(legend, category, series);

		getLogger().info("请求汇总结束:{}",JsonUtils.obj2JsonString(echarts));
		return JsonUtils.obj2JsonString(echarts);
	}
	
	@RequestMapping(value = "/culDate.htm",method={RequestMethod.POST,RequestMethod.GET},produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String culateDate(@RequestParam("startDate")String startDate , @RequestParam("dateNums")String dateNums) {
		getLogger().info("请求参数：startDate:{},dateNums:{}",startDate,dateNums);
		
		String result = DateUtil.sourcePlusInterval(startDate, Integer.valueOf(dateNums));
		getLogger().info("日期计算天数：{}",result);
		return result;
	}
}
