package com.amwang.biz.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**  
* <p>Title: BaseRequest</p>  
* <p>Description:  建行银企直连请求实体类 </p>  
* @author wangyao.m  
* @date 2019年4月11日 下午1:48:45
*/

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TX")
public class BaseRequest<T> {

	//请求序列码
	@XmlElement(name="REQUEST_SN")
	public String requestSn;
	
	//客户号
	@XmlElement(name="CUST_ID")
	public String custId;
	
	//操作员号
	@XmlElement(name="USER_ID")
	public String userId;
	
	//密码
	@XmlElement(name="PASSWORD")
	public String password;
	
	//接口编号
	@XmlElement(name="TX_CODE")
	public String txCode;
	
	//语言
	@XmlElement(name="LANGUAGE")
	public String language;
	
	//签名信息
	@XmlElement(name="SIGN_INFO")
	public String signInfo;
	
	//签名CA信息
	@XmlElement(name="SIGNCERT")
	public String signCert;
	
//	@XmlElement(name="TX_INFO")
	@XmlTransient
	public T info;
	
//	@XmlElement(name="TX_INFO")
//	public Info info;
	
//	@XmlElement(name="TX_INFO")
//	public TxInfo txInfo;
	
//	public void setTxInfo(TxInfo txInfo) {
//		this.txInfo = txInfo;
//	}

//	public void setInfo(Info info) {
//		this.info = info;
//	}

	public T getInfo() {
		return info;
	}

	public void setRequestSn(String requestSn) {
		this.requestSn = requestSn;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTxCode(String txCode) {
		this.txCode = txCode;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setSignInfo(String signInfo) {
		this.signInfo = signInfo;
	}

	public void setSignCert(String signCert) {
		this.signCert = signCert;
	}

	
	public String getRequestSn() {
		return requestSn;
	}

	public String getCustId() {
		return custId;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getTxCode() {
		return txCode;
	}

	public String getLanguage() {
		return language;
	}

	public String getSignInfo() {
		return signInfo;
	}

	public String getSignCert() {
		return signCert;
	}




}
