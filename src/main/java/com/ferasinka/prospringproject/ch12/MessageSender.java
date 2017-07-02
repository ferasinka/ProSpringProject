package com.ferasinka.prospringproject.ch12;

@FunctionalInterface
public interface MessageSender {
	void sendMessage(String message);
}
