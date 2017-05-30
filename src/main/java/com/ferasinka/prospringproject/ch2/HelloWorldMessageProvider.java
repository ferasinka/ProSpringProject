package com.ferasinka.prospringproject.ch2;

//@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
	@Override
	public String getMessage() {
		return "Hello, world!";
	}
}
