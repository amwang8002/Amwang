/**  
* <p>Title: DBF-ROOT  </p>  
* <p>Description: The program was developed to practice new methods and techniques in the learning process.
Just for the sake of learning.</p>  
* <p>Copyright: Copyright amwang (c) 2018</p>  
* <p>Company: www.nourl.com</p>  
* @author amwang  
* @date 2019年3月15日  
* @version 1.0  
*/ 
package com.amwang.temptest;

import java.util.HashMap;
import java.util.Map;

/**  
* <p>Title: RoaminToInt</p>  
* <p>Description: 罗马数组转阿拉伯数字 </p>  
* @author amwang  
* @date 2019年3月15日  
*/
public class RoaminToInt {

	/**  
	 * <p>Title: main</p>  
	 * <p>Description: </p>  
	 * @param args  
	 * Symbol       Value
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums = transfer("XIX");
		System.out.println(nums);
	}
	
	private static int transfer(String s) {
		Map rules = new HashMap();	
		rules.put("I", 1);
		rules.put("V", 5);
		rules.put("X", 10);
		rules.put("L", 50);
		rules.put("C", 100);
		rules.put("D", 500);
		rules.put("M", 1000);
        
		char[] romanChars = s.toCharArray();
		int sum = 0;
		int prev =  (Integer) rules.get(String.valueOf(romanChars[romanChars.length - 1]));
		for(int i= s.length() - 1; i >=0; i--){
			char romanChar = romanChars[i];
			int diff = 0;
			int num = (Integer) rules.get(String.valueOf(romanChar));
			if(num < prev){
				diff = sum - num;
				sum = diff;
			}else{
				sum = sum + num;	
			}
			prev = num;
		}
		return sum;
	}

}
