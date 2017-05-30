package com.ferasinka.prospringproject.ch2;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

//@Service("messageRenderer")
@Named("messageRenderer")
@Singleton
public class StandardOutMessageRenderer implements MessageRenderer {
	private MessageProvider messageProvider;
	
	@Override
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException("You must set the property messageProvider of class: " + StandardOutMessageRenderer.class.getName());
		}
		
		System.out.println(messageProvider.getMessage());
	}
	
	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
	
	@Override
//	@Resource(name = "messageProvider")
	@Inject
	@Named("messageProvider")
	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = provider;
	}
}
