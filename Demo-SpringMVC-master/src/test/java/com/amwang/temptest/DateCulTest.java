/**  
* <p>Title: DBF-ROOT  </p>  
* <p>Description: The program was developed to practice new methods and techniques in the learning process.
Just for the sake of learning.</p>  
* <p>Copyright: Copyright amwang (c) 2018</p>  
* <p>Company: www.nourl.com</p>  
* @author amwang  
* @date 2019年1月30日  
* @version 1.0  
*/ 
package com.amwang.temptest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.utils.DateUtil;
import com.amwang.utils.JsonUtils;

/**  
* <p>Title: DateCulTest</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年1月30日  
*/
public class DateCulTest extends AbstractSpringContextTestSupport {
	
	@Test
	public void testMapPut() {
		Map<String, String> example = new HashMap<String, String>();
		example.put("aa", "aa");
		example.put("bb", "bb");
		
		Map<String, Object> extension = new HashMap<>();
		extension.put("validate", example);
		extension.put("cc", "cc");
		
		System.out.println(JsonUtils.obj2JsonString(extension));
		
		Map<String, String> tomap = (Map<String, String>) extension.get("validate");
		System.out.println(tomap.get("aa"));
	}

	
	@Test
	public void culDateTest() {
		String startDate = "20181023";
		String pointDate = "20181114";
		
		String fmt = "yyyy-MM-dd";
		String fmt2 = "yyyyMMdd";
		
		char start = startDate.charAt(0);
		char start2 = fmt.charAt(0);
		
		System.out.println(start != start2);
		String result1 ;
		String result2 ;
		
//		result1 = DateUtil.getFormatDate(pointDate, -1);
		result1 = DateUtil.sourcePlusInterval(startDate, 99);
		System.out.println("99天后："+result1);
		
		result2 = DateUtil.getAppointDay(fmt2, 3);
		System.out.println("++++"+result2);
	}
	
	
	@Test
	public void base64Encode() {
//		String result = Base64.encode("qwer");
//		System.out.println("qwer:"+result);
		String aaa = "dddddd";
		int result = aaa.indexOf("#");
		System.out.println(result);
	}
	
	@Test
	public void timestr() {
		System.out.println(DateUtil.getCurrentDateTimeStr("EEE"));
		System.out.println(DateUtil.getCurrentDateTimeStr("yyyy-MM-dd EEE HH:mm:ss"));
		System.out.println(DateUtil.getCurrentDateTimeStr("yyyyMMddHHmmssSSS"));
		System.out.println(DateUtil.getCurrentDateTimeStr("yyyyMMddHHmmssSSS").length());
	}
	
	@Test
	public void monthTest() {
		Integer time[] = {1,2,3,4,5,6,7,8,9,10,11,12}; 
		 for (Integer integer : time) {
			 System.out.println(integer +"月，第一天："+DateUtil.getFirstDayOfMonth(integer));
			 System.out.println(integer +"月，最后一天："+DateUtil.getLastDayOfMonth(integer));
		 }
	}
}
