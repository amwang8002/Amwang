package com.amwang.biz.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**  
* <p>Title: BaseRequest</p>  
* <p>Description:  建行银企直连请求实体类 </p>  
* @author wangyao.m  
* @date 2019年4月11日 下午1:48:45
*/

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TX")
public class BaseRequest2<T> {

	//请求序列码
	public String requestSn;
	
	//客户号
	public String custId;
	
	//操作员号
	public String userId;
	
	//密码
	public String password;
	
	//接口编号
	public String txCode;
	
	//语言
	public String language;
	
	//签名信息
	public String signInfo;
	
	//签名CA信息
	public String signCert;
	
	public T info;
	
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
