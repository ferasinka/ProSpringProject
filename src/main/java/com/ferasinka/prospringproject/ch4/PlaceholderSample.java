package com.ferasinka.prospringproject.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PlaceholderSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch4.xml");
		
		AppProperty appProperty = ctx.getBean("appProperty", AppProperty.class);
		
		System.out.println(appProperty.getApplicationHome());
		System.out.println(appProperty.getUserHome());
		
	}
}
