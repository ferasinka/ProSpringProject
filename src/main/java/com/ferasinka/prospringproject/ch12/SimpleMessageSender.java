package com.ferasinka.prospringproject.ch12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

//@Component("messageSender")
//public class SimpleMessageSender implements MessageSender {
//	private final JmsTemplate jmsTemplate;
//
//	@Autowired
//	public SimpleMessageSender(JmsTemplate jmsTemplate) {
//		this.jmsTemplate = jmsTemplate;
//	}
//
//	@Override
//	public void sendMessage(String message) {
//		jmsTemplate.send((session -> session.createTextMessage(message)));
//	}
//}
