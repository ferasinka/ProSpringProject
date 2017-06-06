package com.ferasinka.prospringproject.ch8;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringJpaSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation-ch8.xml");
		
		ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);
		
//		printContacts(contactService.findAll());

//		printContactsWithDetails(contactService.findAllWithDetail());
		
		System.out.println(contactService.findById(1L));
	}
	
	private static void printContacts(List<Contact> contacts) {
		System.out.println();
		System.out.println("Listing contacts without details: ");
		
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
	
	@SuppressWarnings("Duplicates")
	private static void printContactsWithDetails(List<Contact> contacts) {
		System.out.println();
		System.out.println("Listing contacts with details:");
		
		for (Contact contact : contacts) {
			System.out.println(contact);
			
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
					System.out.println(contactTelDetail);
				}
			}
			
			if (contact.getHobbies() != null) {
				for (Hobby hobby : contact.getHobbies()) {
					System.out.println(hobby);
				}
			}
		}
	}
}
