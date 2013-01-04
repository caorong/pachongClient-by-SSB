package com.cr.modules.sample.remote.impl;

import com.cr.modules.sample.remote.SampleRemote;
import com.cr.support.jms.WsTransport;

/**
 * @Description 
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class SampleRemoteImpl implements SampleRemote {

	@Override
	public void sendSamplRegMessage(String message) {
		wsTransport.sendMessage(message);
	}
	
	private WsTransport wsTransport;

	public void setWsTransport(WsTransport wsTransport) {
		this.wsTransport = wsTransport;
	}
}
