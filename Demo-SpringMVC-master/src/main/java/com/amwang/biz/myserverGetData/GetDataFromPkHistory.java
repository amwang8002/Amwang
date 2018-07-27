package com.amwang.biz.myserverGetData;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.amwang.biz.serverModel.entity.TPkHisManual;
import com.amwang.common.LogBase;

@Component
public class GetDataFromPkHistory extends LogBase{
	protected final static Logger log = LoggerFactory.getLogger(GetDataFromPkHistory.class);
	
	public static TPkHisManual getDataFromPkHistory(String httpUrl) {
	
		TPkHisManual record = null;
		Document doc = null;
		try {
			doc = Jsoup.connect(httpUrl)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36")
					.timeout(10000).post();
		} catch (IOException e) {
			log.error("获取彩专家网站内容失败：{}{}",e,e.getMessage());
		}
		
		List<Element> elements = doc.getElementsByAttributeValue("class", "cz7");//获取元素节点等
		Elements element = elements.get(0).getElementsByTag("li");
		int count = 0;
		for (Element li : element) {
			if (count == 0) {
				count++;
				continue;
			}
			if (count == 1) {
				record  = new TPkHisManual();
				// 数据落地
				record.setContent(li.text());
				return record;
			}
		}
		
		
		return record;
	}
	
}
