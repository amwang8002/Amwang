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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
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
}
