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

import org.junit.Test;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.utils.DateUtil;

/**  
* <p>Title: DateCulTest</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年1月30日  
*/
public class DateCulTest extends AbstractSpringContextTestSupport {

	
	@Test
	public void culDateTest() {
		String startDate = "20181023";
		String pointDate = "20181114";
		
		String fmt = "yyyy-MM-dd";
		String fmt2 = "yyyyMMdd";
		
		String result1 ;
		String result2 ;
		
//		result1 = DateUtil.getFormatDate(pointDate, -1);
		result1 = DateUtil.sourcePlusInterval(startDate, 99);
		System.out.println("99天后："+result1);
		
		result2 = DateUtil.getAppointDay(fmt2, 3);
		System.out.println("++++"+result2);
	}
}
