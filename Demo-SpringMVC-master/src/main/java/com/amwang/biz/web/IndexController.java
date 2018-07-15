package com.amwang.biz.web;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amwang.biz.dwmodel.entity.DwTrade;
import com.amwang.biz.model.entity.RiskRule;
import com.amwang.biz.service.RiskRuleService;
import com.amwang.biz.service.SumDwTradeService;
import com.amwang.common.utils.JsonUtils;

@Controller
@RequestMapping
public class IndexController {

	private transient Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private RiskRuleService riskRuleService;

	@Autowired
	private SumDwTradeService sumDwTradeService;

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

		log.info("请求汇总开始");
		List<DwTrade> listResult = sumDwTradeService.sumPrdInfo();
		BigDecimal sumCount = new BigDecimal(0);
		if (!CollectionUtils.isEmpty(listResult)) {
			for (DwTrade dwTrade : listResult) {
				sumCount = sumCount.add(dwTrade.getNum());
			}
		}
		mView.addObject("sum", sumCount.toString()).addObject("result", JsonUtils.list2JsonString(listResult));
		log.error("汇总请求错误提示");
		mView.setViewName("sumPage");
		log.info("请求汇总结束");
		return mView;

	}

}