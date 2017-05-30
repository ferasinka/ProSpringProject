package com.ferasinka.prospringproject.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactoryExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch4.xml");
		
		MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
		digester.digest("Hello, world!");
	}
}
