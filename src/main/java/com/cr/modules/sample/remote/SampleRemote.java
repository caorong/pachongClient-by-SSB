package com.cr.modules.sample.remote;

/**
 * @Description sample服务调用接口 
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public interface SampleRemote {

	/**
	 * @Description 发送样例注册信息
	 * @param message
	 * @author caobin
	 */
	void sendSamplRegMessage(final String message);
}
