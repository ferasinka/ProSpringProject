package com.ferasinka.prospringproject.ch12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SimpleMessageListener implements MessageListener {
	private static final Logger LOG = LoggerFactory.getLogger(SimpleMessageListener.class);
	
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		
		try {
			LOG.info("Message received: " + textMessage.getText());
		} catch (JMSException e) {
			LOG.error("JMS Error", e);
		}
	}
}
