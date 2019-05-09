package com.amwang.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**  
* <p>Title: XMLUtils</p>  
* <p>Description:  xml格式转换工具类 </p>  
* @author wangyao.m  
* @date 2019年4月11日 下午1:41:26
*/
public class XMLUtils {

	/**
	 * 
	 * <p>Description: 将实体对象转换为xml格式 </p>  
	 * <p>Title: convertObjToXml</p>  
	 * @param obj
	 * @return
	 */
	public String convertObjToXml(Object obj) {
		StringWriter sw = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "GB2312");
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
	}
	
	/**
	 * 
	 * <p>Title: convertXmlStrToObject</p>  
	 * <p>Description: 转换xml文件为实体对象 </p>  
	 * @param clazz
	 * @param xmlStr
	 * @return
	 */
	public Object convertXmlStrToObject(Class clazz, String xmlStr) {  
        Object xmlObject = null;  
        try {  
            JAXBContext context = JAXBContext.newInstance(clazz);  
            // 进行将Xml转成对象的核心接口  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            StringReader sr = new StringReader(xmlStr); 
            xmlObject = unmarshaller.unmarshal(sr);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
        return xmlObject;  
    }  
}
