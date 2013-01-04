package com.cr.support.jms.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.cr.support.jms.WsTransport;

/**
 * @Description 
 * @author caobin
 * @date 2012-11-19
 * @version 1.0
 */
public class DefaultWsTransport implements WsTransport {

	@Override
	public void sendMessage(String message) {
		send(message, notifyQueue);
	}

	/**
	 * @Description 通过jmsTemplate的发送消息.
	 * @param message
	 * @param destination
	 * @return
	 * @author caobin
	 */
	private void send(final String message, Destination destination){
		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
	
	protected transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	private JmsTemplate jmsTemplate;
	private Destination notifyQueue;
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	public void setNotifyQueue(Destination notifyQueue) {
		this.notifyQueue = notifyQueue;
	}
}
