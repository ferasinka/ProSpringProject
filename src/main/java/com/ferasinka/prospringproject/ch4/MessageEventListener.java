package com.ferasinka.prospringproject.ch4;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
	@Override
	public void onApplicationEvent(MessageEvent event) {
		System.out.println("Received: " + event.getMessage());
	}
}
