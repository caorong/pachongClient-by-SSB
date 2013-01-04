package com.cr.support.jms;

/**
 * @Description web service传输接口
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public interface WsTransport {
	
	/**
	 * @Description 发送消息(异步 )
	 * @param message
	 * @author caobin
	 */
	void sendMessage(final String message);
}
