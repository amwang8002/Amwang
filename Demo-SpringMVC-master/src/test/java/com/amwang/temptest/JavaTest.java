package com.amwang.temptest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amwang.utils.JsonUtils;

/**  
 * 
* <p>Title: JavaTest</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年6月11日  
*/ 
public class JavaTest {

	public static void main(String[] args) throws Exception {
		
		Map<String, String> example = new HashMap<String, String>();
		example.put("aa", "aa");
		example.put("bb", "bb");
		
		Map<String, Object> extension = new HashMap<>();
		extension.put("validate", example);
		
//		List<String> list1 = new ArrayList<String>();
//		List<String> list2 = new ArrayList<String>();
//		for (int i = 0; i < 10; i++) {
//			list1.add("test" + i);
//			list2.add("test" + i*2);
//		}
//		System.out.println(JsonUtils.list2JsonString(list1));
//		System.out.println(JsonUtils.list2JsonString(list2));
//		
//		System.out.println(equalList(list1, list2));
//		
		
//		strContain();
		String restlt = "";
		String jack = "jack";
		String tom = "Tom";
		String marry = "marry";
		String china = "中华人民共和国合同法";
		
		int capcity = jack.length()+tom.length()+marry.length()+china.length()+13;
		System.out.println("字符串长度："+capcity);
//		StringBuffer sBuilder = new StringBuffer();
		StringBuffer sBuilder = new StringBuffer(1000);
		System.out.println("初始容量:"+sBuilder.capacity()+">>初始长度:"+sBuilder.length());
//		sBuilder.setLength(3);
//		System.out.println("扩容后:"+sBuilder.capacity()+"长度:"+sBuilder.length()); .append("000000000000")
		long star = System.currentTimeMillis();
		System.out.println("开始时间："+star);
		for (int i = 0; i < 9000000; i++) {
			sBuilder.append(jack).append(tom).append(marry).append(china).append("000000000000");
//			restlt += jack+tom+marry+china+"000000000000";
		}
		long end = System.currentTimeMillis();
		long his = end-star;
		System.out.println("结束时间："+end+"耗时："+his);
		System.out.println("最终容量:"+sBuilder.capacity()+">>最终长度:"+sBuilder.length()+">>>"+restlt.length());
//		System.out.println(sBuilder.toString());
		
		URL url = new URL("http://www.baidu.com");
		HttpURLConnection hcon = (HttpURLConnection) url.openConnection();
		BufferedReader bfr = new BufferedReader(new InputStreamReader(hcon.getInputStream(), "UTF-8"));
		while (null != bfr.readLine()) {
			int leth = bfr.readLine().length();
			System.out.println(leth);
			System.out.println();
		}
	}

	public static boolean equalList(List list1, List list2) {
		if (list1.size() != list2.size())
			return false;
		for (Object object : list1) {
			if (!list2.contains(object))
				return false;
		}
		return true;
	}
	
	public static void strContain() {
		String msString = "验证密码异常";
		System.out.println(msString.contains("验证密码"));
		System.out.println(msString.startsWith("验证密码"));
		
		String result = msString.contains("锁定")? "lock": msString.contains("错误")? "failed":msString.contains("异常")? msString:"error" ;
		
		System.out.println(result);
	}
	
}
