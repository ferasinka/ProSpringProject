package com.ferasinka.prospringproject.ch5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-aspectj.xml");
		
		MessageWriter writer = new MessageWriter();
		writer.writeMessage();
		writer.foo();
	}
}
