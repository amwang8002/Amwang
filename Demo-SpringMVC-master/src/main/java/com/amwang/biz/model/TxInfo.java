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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**  
* <p>Title: TxInfo</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年4月11日  
*/
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name="TX_INFO")
public class TxInfo implements Serializable {

	/** serialVersionUID*/  
	private static final long serialVersionUID = 9201135013162736187L;

	@XmlElement(name="TRAN_TYPE")
	private String tranType;
	
	@XmlElement(name="PAY_ACCNO")
	private String payAccNo;
	
	@XmlElement(name="RECE_ACCNO")
	private String receAccNo;

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public void setPayAccNo(String payAccNo) {
		this.payAccNo = payAccNo;
	}

	public void setReceAccNo(String receAccNo) {
		this.receAccNo = receAccNo;
	}

	public String getTranType() {
		return tranType;
	}

	public String getPayAccNo() {
		return payAccNo;
	}

	public String getReceAccNo() {
		return receAccNo;
	}

	
}
