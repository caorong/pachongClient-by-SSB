package com.cr.support.util;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.cr.modules.sample.model.SampleReg;
import com.thoughtworks.xstream.XStream;

/**
 * @Description 消息处理工具(根据具体需求再进行定制)
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class MessageUtils {

	/**
	 * @Description bean to xml (通过具体需求定制)
	 * @param bean
	 * @return
	 * @throws UnsupportedEncodingException
	 * @author caobin
	 */
	public static<BEAN> String toXml(BEAN bean) throws UnsupportedEncodingException{
		XStream xstream = new XStream();		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();		
		xstream.toXML(bean, outputStream);		
		return new String(outputStream.toByteArray(), "utf-8");
	}
}
