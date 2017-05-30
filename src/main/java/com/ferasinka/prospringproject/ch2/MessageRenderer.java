package com.ferasinka.prospringproject.ch2;

public interface MessageRenderer {
	void render();
	
	MessageProvider getMessageProvider();
	
	void setMessageProvider(MessageProvider provider);
}
