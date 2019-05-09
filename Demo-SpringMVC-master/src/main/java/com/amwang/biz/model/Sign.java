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

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**  
* <p>Title: Sign</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年4月11日  
*/
@XmlRootElement(name="TX_INFO")
public class Sign implements Serializable {
	
	/** serialVersionUID*/  
	private static final long serialVersionUID = 2323763661687448130L;

	@XmlElement(name="SIGN_CERT")
	private String sginCert;

	@XmlElement(name="SIGN")
	private String sign;

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setSginCert(String sginCert) {
		this.sginCert = sginCert;
	}
	
	
	
}
