/**  
* <p>Title: DBF-ROOT  </p>  
* <p>Description: The program was developed to practice new methods and techniques in the learning process.
Just for the sake of learning.</p>  
* <p>Copyright: Copyright amwang (c) 2018</p>  
* <p>Company: www.nourl.com</p>  
* @author amwang  
* @date 2019年4月30日  
* @version 1.0  
*/ 
package com.amwang.temptest;

import org.junit.Test;

import com.amwang.biz.AbstractSpringContextTestSupport;

/**  
* <p>Title: SplitTest</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年4月30日  
*/
public class SplitTest extends AbstractSpringContextTestSupport {

	@Test
	public void splitT() {
		String filePath = "/azuredev/9999999/20190430/TNMER20190430171929965_20190426121442.jpg";
		
		int loc = filePath.lastIndexOf("/");
		System.out.println(loc);
		System.out.println(filePath.substring(0, filePath.lastIndexOf("/")+1));
	}
}
