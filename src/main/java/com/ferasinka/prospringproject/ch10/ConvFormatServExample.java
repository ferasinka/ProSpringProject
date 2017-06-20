package com.ferasinka.prospringproject.ch10;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

public class ConvFormatServExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/conv-format-service-app-context-ch10.xml");
		
		Contact chris = ctx.getBean("chris", Contact.class);
		System.out.println(chris);
		
		ConversionService conversionService = ctx.getBean("conversionService", ConversionService.class);
		System.out.println("Birthdate of contact is: " + conversionService.convert(chris.getBirthDate(), String.class));
	}
}
