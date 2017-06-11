package com.ferasinka.prospringproject.ch8.springdatajpa;

import com.ferasinka.prospringproject.ch8.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringDataJpaSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation-ch8.xml");
		
		ContactService contactService = ctx.getBean("springJpaContactService", ContactService.class);
		
		printContacts("Find all:", contactService.findAll());
		printContacts("Find by first name:", contactService.findByFirstName("Chris"));
		printContacts("Find by first and last name:", contactService.findByFirstNameAndLastName("Chris", "Schaefer"));
	}
	
	private static void printContacts(String message, List<Contact> contacts) {
		System.out.printf("%n%s%n", message);
		
		for (Contact contact : contacts) {
			System.out.printf("%s%n", contact);
		}
	}
}
