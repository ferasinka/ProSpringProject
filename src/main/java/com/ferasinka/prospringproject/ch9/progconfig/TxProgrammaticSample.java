package com.ferasinka.prospringproject.ch9.progconfig;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TxProgrammaticSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/tx-programmatic-app-context-ch9.xml");
		
		ContactService contactService = ctx.getBean("contactService", ContactService.class);
		
		System.out.println("Contact count: " + contactService.countAll());
	}
}
