package com.ferasinka.prospringproject.ch12;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JmsSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.load("spring/jms-sender-app-context-ch12.xml");
		ctx.load("spring/jms-listener-app-context-ch12.xml");
		ctx.refresh();
		
		MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);
		
		for (int i = 0; i < 10; i++) {
			messageSender.sendMessage("Test message: " + i);
		}
	}
}
