/**  
* <p>Title: DBF-ROOT  </p>  
* <p>Description: The program was developed to practice new methods and techniques in the learning process.
Just for the sake of learning.</p>  
* <p>Copyright: Copyright amwang (c) 2018</p>  
* <p>Company: www.nourl.com</p>  
* @author amwang  
* @date 2019年2月18日  
* @version 1.0  
*/ 
package com.amwang.temptest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;
import org.jsoup.helper.StringUtil;
import org.junit.Test;

import com.amwang.biz.AbstractSpringContextTestSupport;

/**  
* <p>Title: MapTest</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年2月18日  
*/
public class MapTest extends AbstractSpringContextTestSupport {

	@Test
	public void bindMap() {
		Map<String, String> one = new HashMap<String, String>();
		one.put("1", "1");
		one.put("2", "2");
		
		Map<String, String> two = new HashMap<String, String>();
		two.put("1", "3");
		two.put("3", "3");
		two.put("4", "4");
		
		Map<String, String> three = new HashMap<String, String>();
	
		String split = "-";
		StringBuffer sBuffer = new StringBuffer();
		
		for (String twoKeys : two.keySet()) {
				for(String oneKeys : one.keySet()) {
					if (oneKeys.equals(twoKeys)) {
						System.out.println("key一样的");
						System.out.println(one.get(oneKeys)+"+"+two.get(twoKeys));
						
					} else {
						System.out.println("key不一样的");
						if (!split.contains(twoKeys)) {
							sBuffer.append(twoKeys).append(split);
						}
						if (!split.contains(oneKeys)) {
							sBuffer.append(oneKeys).append(split);
						}
						
					}
				}
		}
		String [] keys = sBuffer.toString().split(split);
		System.out.println(ArrayUtils.toString(keys));
		System.out.println("合并后》》》》》》");
		for (String onekey : one.keySet()) {
			System.out.println(onekey+":"+one.get(onekey));
		}
	}
	
	
	@Test
	public void validateMobileTest() {
		boolean result = isMobile("18756082221");
		System.out.println(result);
	}
	
	@Test
	public void testCount() {
		int i = 8;
		int l = 8;
		
		int m = i++;
		int n = ++l;
		
		System.out.println(m+"-->"+i);
		System.out.println(n+"-->"+l);
	}
	
	public boolean isMobile(String str) {
        if(StringUtil.isBlank(str)){
            return false;
        }
        //手机号长度和格式不限制
//        return true;
//        //1\\d{10}
          String check = "^[1][3,4,5,7,8][0-9]{9}$";
//        String check = "^1\\d{0-10}$";
//        String check = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|2|3|5|6|7|8|9])\\d{8}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(str.trim());
        return matcher.matches();
	}
	
	@Test
	public void testListSize() {
		List<String> liStrings = new ArrayList<String>();
		for (int i = 1; i <= 10 ; i++) {
			liStrings.add(String.valueOf(i));
		}
		
		int count = 1;
		for (String string : liStrings) {
			if (liStrings.size() == count) {
				
				System.out.println(10+"--"+string);
			} else {
				System.out.println(string);
			}
			count++;
		}
	}
}
