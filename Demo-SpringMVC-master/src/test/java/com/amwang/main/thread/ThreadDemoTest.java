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

/**
 * <p>
 * Title: ThreadDemoTest
 * </p>
 * <p>
 * Description: 线程测试类
 * </p>
 * 
 * @author amwang
 * @date 2019年6月4日
 */
public class ThreadDemoTest implements Runnable {

	private Thread t;
	private String threadName;

	ThreadDemoTest( String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	/**
	 * (non-Javadoc)
	 * <p>
	 * Title: run
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public void run() {
		 System.out.println("Running " +  threadName );
	      try {
	         for(int i = 40; i > 0; i--) {
	            System.out.println("Thread: " + threadName + ", " + i);
	            // 让线程睡眠一会
	            Thread.sleep(50);
	         }
	      }catch (InterruptedException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      System.out.println("Thread " +  threadName + " exiting.");

	}

	public void start() {
		 System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	}
	
	public static void main(String[] args) {
		ThreadDemoTest d1 = new ThreadDemoTest("thr-1");
		d1.start();
		
		ThreadDemoTest d2 = new ThreadDemoTest("thr-2");
		d2.start();
		
		ThreadDemoTest d3 = new ThreadDemoTest("thr-3");
		d3.start();
		
	}

}
