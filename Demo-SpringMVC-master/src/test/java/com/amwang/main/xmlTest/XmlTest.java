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
package com.amwang.main.xmlTest;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.model.BaseRequest;
import com.amwang.biz.model.BaseRequest2;
import com.amwang.biz.model.Info;
import com.amwang.biz.model.TxInfo;
import com.amwang.utils.DateUtil;
import com.amwang.utils.JsonUtils;
import com.amwang.utils.XMLUtils;

/**  
* <p>Title: XmlTest</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年4月11日  
*/
public class XmlTest extends AbstractSpringContextTestSupport {

	//  <?xmlversion="1.0"encoding="GB2312"standalone="yes"?><TX><REQUEST_SN>02KDKDIEdfse</REQUEST_SN><CUST_ID>123</CUST_ID><PASSWORD>****</PASSWORD><TX_CODE>6W8060</TX_CODE><LANGUAGE>CN</LANGUAGE><SIGN_INFO>req000000</SIGN_INFO><SIGNCERT>sdf3dde</SIGNCERT><TX_INFO><SIGN>sdfsleee</SIGN><PAY_ACCNO>pay001</PAY_ACCNO><PAY_ACCNO>rec002</PAY_ACCNO></TX_INFO></TX>
	@SuppressWarnings("unchecked")
	@Test
	public void test11() {
		String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\"?><TX>    <REQUEST_SN>02KDKDIEdfse</REQUEST_SN>    <CUST_ID>123</CUST_ID>    <PASSWORD>****</PASSWORD>    <TX_CODE>6W8060</TX_CODE>    <LANGUAGE>CN</LANGUAGE>    <SIGN_INFO>req000000</SIGN_INFO>    <SIGNCERT>sdf3dde</SIGNCERT>    <TX_INFO><TRAN_TYPE>转账</TRAN_TYPE>        <PAY_ACCNO>pay001</PAY_ACCNO>        <RECE_ACCNO>rec002</RECE_ACCNO>    </TX_INFO></TX>";
		XMLUtils xmlUtils = new XMLUtils();
		String txCode = xml.substring(xml.indexOf("<TX_CODE>")+9, xml.indexOf("</TX_CODE>"));
		System.out.println(txCode);
		String txInfo = xml.substring(xml.indexOf("<TX_INFO>"), xml.indexOf("</TX_INFO>")+10);
		System.out.println(txInfo);
		BaseRequest<TxInfo> request = (BaseRequest<TxInfo>) xmlUtils.convertXmlStrToObject(BaseRequest.class, xml);
		TxInfo txInfo2 = (TxInfo) xmlUtils.convertXmlStrToObject(TxInfo.class, txInfo);
		
		System.out.println(JsonUtils.obj2JsonString(txInfo2));
		System.out.println(JsonUtils.obj2JsonString(request));
		request.setInfo(txInfo2);
//		BaseRequest2<TxInfo> request2 = new BaseRequest2<TxInfo>();
//		BeanUtils.copyProperties(request, request2);
//		request2.setInfo(txInfo2);
		
//		System.out.println(JsonUtils.obj2JsonString(request2));
		
		System.out.println(JsonUtils.obj2JsonString(request.getInfo()));
	}
	
	public static void main(String[] args) {
		TxInfo info = new TxInfo();
		
		info.setPayAccNo("pay001");
		info.setReceAccNo("rec002");
		info.setTranType("转账");
//		info.setSign("sdfsleee");
//		info.setSginCert("cert000");
		
//		Info in = new Info();
//		in.setRem1("rem222");
//		in.setRem2("rem1111");
		
		BaseRequest<TxInfo> request = new BaseRequest<TxInfo>();
//		request.setInfo(info);
//		request.setTxInfo(info);
//		request.setInfo(in);
		
		request.setCustId("123");
		request.setLanguage("CN");
		request.setRequestSn("02KDKDIEdfse");
		request.setPassword("****");
		request.setSignInfo("req000000");
		request.setSignCert("sdf3dde");
		request.setTxCode("6W8060");
		
		XMLUtils xmlUtils = new XMLUtils();
		
		String xmlfile = xmlUtils.convertObjToXml(request);
		System.out.println(xmlfile.replaceAll("\r\n|\t|\n|\t", ""));
		System.out.println(xmlfile);
		// .replaceAll("\r\n|\t|\n|\t", "")
	}
}
