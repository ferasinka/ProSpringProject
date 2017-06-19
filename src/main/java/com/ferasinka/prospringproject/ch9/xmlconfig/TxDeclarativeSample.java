package com.ferasinka.prospringproject.ch9.xmlconfig;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class TxDeclarativeSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/tx-declarative-app-context-ch9.xml");
		
		ContactService contactService = ctx.getBean("contactService", ContactService.class);
		
		List<Contact> contacts = contactService.findAll();
		
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		
		// -----------------------------------------------
		
		Contact contact = contactService.findById(1L);
		contact.setFirstName("Peter");
		
		contactService.save(contact);
		
		System.out.println("Contact saved successfully: " + contact);
		
		// -----------------------------------------------
		
		System.out.println("Contact count: " + contactService.countAll());
	}
}
