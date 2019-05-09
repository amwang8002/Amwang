/**  
* <p>Title: DBF-ROOT  </p>  
* <p>Description: The program was developed to practice new methods and techniques in the learning process.
Just for the sake of learning.</p>  
* <p>Copyright: Copyright amwang (c) 2018</p>  
* <p>Company: www.nourl.com</p>  
* @author amwang  
* @date 2019年4月11日  
* @version 1.0  
*/ 
package com.amwang.biz.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**  
* <p>Title: Info</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年4月11日  
*/

@XmlAccessorType(XmlAccessType.PROPERTY)
public class Info {
	
	@XmlElement(name="REM1")
	private String rem1;
	
	@XmlElement(name="REM2")
	private String rem2;

	public void setRem2(String rem2) {
		this.rem2 = rem2;
	}

	public void setRem1(String rem1) {
		this.rem1 = rem1;
	}
	
	
}
