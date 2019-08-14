/**  
* <p>Title: DBF-ROOT  </p>  
* <p>Description: The program was developed to practice new methods and techniques in the learning process.
Just for the sake of learning.</p>  
* <p>Copyright: Copyright amwang (c) 2018</p>  
* <p>Company: www.nourl.com</p>  
* @author amwang  
* @date 2019年7月30日  
* @version 1.0  
*/ 
package com.amwang.utils;

import java.util.Random;

/**  
* <p>Title: ChartUtils</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年7月30日  
*/
public class ChartUtils {

	public static String getRandomStr(int count)
	  {
	    String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < count; i++)
	    {
	      int number = random.nextInt(base.length());
	      sb.append(base.charAt(number));
	    }
	    return sb.toString();
	  }
	  
	  public static byte[] int2Bytes(int count)
	  {
	    byte[] byteArr = new byte[4];
	    byteArr[3] = ((byte)(count & 0xFF));
	    byteArr[2] = ((byte)(count >> 8 & 0xFF));
	    byteArr[1] = ((byte)(count >> 16 & 0xFF));
	    byteArr[0] = ((byte)(count >> 24 & 0xFF));
	    return byteArr;
	  }
	  
	  public static int bytes2int(byte[] byteArr)
	  {
	    int count = 0;
	    for (int i = 0; i < 4; i++)
	    {
	      count <<= 8;
	      count |= byteArr[i] & 0xFF;
	    }
	    return count;
	  }
}
