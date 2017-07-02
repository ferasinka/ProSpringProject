package com.ferasinka.prospringproject.ch12;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class HttpInvokerClientSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/http-invoker-app-context-ch12.xml");
		
		ContactService contactService = ctx.getBean("remoteContactService", ContactService.class);
		
		System.out.println("Finding all contacts");
		
		List<Contact> contacts = contactService.findAll();
		
		printAllContacts(contacts);
		
		System.out.println("Finding contact with first name equals Chris");
		
		contacts = contactService.findByFirstName("Chris");
		
		printAllContacts(contacts);
	}
	
	private static void printAllContacts(List<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		
		System.out.println();
	}
}
