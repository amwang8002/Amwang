package com.amwang.biz.myserverGetData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.common.LogBase;
import com.amwang.utils.JsonUtils;

public class GetDataFromBeisai extends LogBase {
	protected final static Logger log = LoggerFactory.getLogger(GetDataFromBeisai.class);

	public static List<TbeisaiData> getUrlInfo(String httpurl) throws IOException {
		List<TbeisaiData> demos = new ArrayList<TbeisaiData>();
		TbeisaiData demo =null;
		boolean flag = false;
		Document doc = null;
		try {
			log.info("开始请求客户端,请求网址{}",httpurl);
			doc = Jsoup.connect(httpurl)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36")
					.timeout(10000).post();
		} catch (IOException e) {
			log.error("请求失败：{}",e);
			throw new IOException(e);
		}
		log.info("请求内容：{}",doc);
		Elements elements = doc.getElementsByTag("td");// 找到所有a标签
		int num = 0;
		for (Element element : elements) {
			if (!StringUtils.isEmpty(element.text())) {
				log.info("数据信息：{}",element.text());
				String attr = element.text();
				if (attr.contains("-")) {
					if (flag) {
						log.info("数据信息组装完毕：{}",JsonUtils.obj2JsonString(demo));
						num++;
						demos.add(demo);
						flag = false;
						if (num == 2) {
							break;
						}
//						return demo;
					} else {
						demo = new TbeisaiData();
						demo.setOpendate(attr);
						flag = true;
					}
				}
				if (Pattern.compile("[0-9]*").matcher(attr).matches()) {
					log.info("期数或总和>>>>>>{}",attr);
					if (attr.length() == 2 || attr.length() == 1) {
						demo.setSum(attr);
						if (Integer.valueOf(attr).compareTo(11) > 0) {
							demo.setBigOrSmall("大");
						} else {
							demo.setBigOrSmall("小");
						}
						if (Integer.valueOf(attr) % 2 == 0) {
							demo.setSingleOrDouble("双");
						} else {
							demo.setSingleOrDouble("单");
						}
					} else if (attr.length() >5) {
						log.info("期数：{}",attr);
						demo.setTextno(attr);
						
					}
				}
			}
			Elements tabname = element.getElementsByTag("span");
			log.info("数据内容：{}",tabname);
			if (tabname.size() == 10) {
				for (int j = 0; j < tabname.size(); j++) {
					String value = tabname.get(j).attr("class");
					if (value.contains("Bwi")) {
						int length = value.length();
						value = value.substring(length-2,length-1);
					}
					if (j == 0) {
						demo.setNum1(value);
					} else if (j == 1) {
						demo.setNum2(value);
					} else if (j == 2) {
						demo.setNum3(value);
					} else if (j == 3) {
						demo.setNum4(value);
					} else if (j == 4) {
						demo.setNum5(value);
					} else if (j == 5) {
						demo.setNum6(value);
					} else if (j == 6) {
						demo.setNum7(value);
					} else if (j == 7) {
						demo.setNum8(value);
					} else if (j == 8) {
						demo.setNum9(value);
					} else if (j == 9) {
						demo.setNum10(value);
					}
				}
			}
		}
		demos.add(demo);
		return demos;
	}
	
}
