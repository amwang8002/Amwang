package com.amwang.biz.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amwang.biz.model.entity.RiskRule;
import com.amwang.biz.serverModel.entity.SumEachNum;
import com.amwang.biz.service.MyserverGetDataService;
import com.amwang.biz.service.RiskRuleService;
import com.amwang.common.MyServerPageModel;
import com.amwang.utils.Echarts;
import com.amwang.utils.JsonUtils;
import com.amwang.utils.Series;

@Controller
@RequestMapping
public class IndexController {

	private transient Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private RiskRuleService riskRuleService;

	@Autowired
	private MyserverGetDataService dataService;

	@RequestMapping("/index")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mView = new ModelAndView();
		log.info("logback 成功了");
		log.error("logback 成功了");
		log.debug("logback 成功了");
		RiskRule result = riskRuleService.selectByRiskRuleId(13L);

		mView.setViewName("demo-charts");
		mView.addObject("message", "SPRING PROJECT TEST!");
		mView.addObject("rule", result);
		return mView;
	}

	@RequestMapping("/sumPrd")
	public ModelAndView sumPrdList() {
		ModelAndView mView = new ModelAndView();
//		MyServerPageModel pageModel = dataService.sumEachNum();
//		
//		mView.addObject("sum", pageModel.getCount()).addObject("result", JsonUtils.list2JsonString(pageModel.getSumEachNums()));
		mView.setViewName("sumPage");
		return mView;

	}
	
	@ResponseBody
	@RequestMapping(value = "showSum" ,method={RequestMethod.POST,RequestMethod.GET})
	public void showNum1Rate(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		log.info("请求汇总开始");
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

		log.info("请求汇总结束:{}",JsonUtils.obj2JsonString(echarts));
		out.println(JsonUtils.obj2JsonString(echarts));
		out.flush();
		out.close();
//		return echarts;
	}
	
	@RequestMapping(value = "showAjaxPage")
	public ModelAndView showAjax() {
		ModelAndView mView = new ModelAndView();
		
		mView.setViewName("ajax");
		return mView;
	}
}