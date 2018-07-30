package com.amwang.main;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.amwang.biz.AbstractSpringContextTestSupport;

public class GetPkhistoryTest extends AbstractSpringContextTestSupport {

	@Test
	public void getInfoFromUrlTest() {
		getInfoFromUrl("http://www.100585.cn/pkhistory.php");
	
	}
	
	private void getInfoFromUrl(String httpurl) {
		
		Document doc = null;
		try {
			doc = Jsoup.connect(httpurl)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36")
					.timeout(10000).post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Elements elements = doc.getElementsByTag("ul");// 找到所有a标签
		List<Element> elements = doc.getElementsByAttributeValue("class", "cz7");//获取元素节点等
		Elements element = elements.get(0).getElementsByTag("li");
		for (Element li : element) {
			String[] textno = li.text().substring(0, 14).split("-");
			int a = Integer.valueOf(textno[0])+1;
			if (ArrayUtils.contains(textno, "695037") || String.valueOf(a).equals("695037")) {
				System.out.println(li.text()+":::::");
			}
			if (li.text().contains("挂")) {
				System.out.println(li.text());
			}
		}
	}
	
	@Test
	public void testString() {
		String aString = "695120-695122期 冠军【10,02,05,06,07】 695121期 06,02,04,09,03,10,01,07,08,05 挂2";
		
		if (aString.contains("中")) {
			System.out.println(aString);
		}
		if (aString.contains("挂")) {
			System.out.println("+++++挂++++++");
		}
	}
}
