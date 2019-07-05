/**  
* <p>Title: DBF-ROOT  </p>  
* <p>Description: The program was developed to practice new methods and techniques in the learning process.
Just for the sake of learning.</p>  
* <p>Copyright: Copyright amwang (c) 2018</p>  
* <p>Company: www.nourl.com</p>  
* @author amwang  
* @date 2019年6月4日  
* @version 1.0  
*/ 
package com.amwang.main.thread;

import org.junit.Test;

import com.amwang.biz.AbstractSpringContextTestSupport;

/**  
* <p>Title: ThreadRunTest</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年6月4日  
*/
public class ThreadRunTest extends AbstractSpringContextTestSupport {

	@Test
	public void threadRun() {
		ThreadDemoTest demo1 = new ThreadDemoTest("thr-1");
		demo1.start();
		
		ThreadDemoTest demo2 = new ThreadDemoTest("thr-2");
		demo2.start();
		
		ThreadDemoTest demo3 = new ThreadDemoTest("thr-2");
		demo3.start();
		
	}
}
