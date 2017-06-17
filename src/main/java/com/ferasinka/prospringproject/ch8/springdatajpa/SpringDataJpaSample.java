package com.ferasinka.prospringproject.ch8.springdatajpa;

import com.ferasinka.prospringproject.ch8.Contact;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class SpringDataJpaSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation-ch8.xml");

//		ContactService contactService = ctx.getBean("springJpaContactService", ContactService.class);
//		printContacts("Find all:", contactService.findAll());
//		printContacts("Find by first name:", contactService.findByFirstName("Chris"));
//		printContacts("Find by first and last name:", contactService.findByFirstNameAndLastName("Chris", "Schaefer"));
		
		ContactAuditService contactAuditService = ctx.getBean("contactAuditService", ContactAuditService.class);
		
		List<ContactAudit> contacts = contactAuditService.findAll();
		printAuditContacts(contacts);
		
		System.out.println("Add new contact");
		
		ContactAudit contact = new ContactAudit();
		contact.setFirstName("Michael");
		contact.setLastName("Jackson");
		contact.setBirthDate(new Date());
		
		contactAuditService.save(contact);
		
		contacts = contactAuditService.findAll();
		
		printAuditContacts(contacts);
		
		contact = contactAuditService.findById(1L);
		
		System.out.println();
		System.out.println("Contact with id 1: " + contact);
		System.out.println();
		
		System.out.println("Update contact");
		
		contact.setFirstName("Tom");
		
		contactAuditService.save(contact);
		
		contacts = contactAuditService.findAll();
		
		printAuditContacts(contacts);
		
		ContactAudit oldContact = contactAuditService.findAuditByRevision(1L, 1);
		
		System.out.println();
		System.out.println("Old contact with id 1 and rev 1: " + oldContact);
		System.out.println();
		
		oldContact = contactAuditService.findAuditByRevision(1L, 2);
		
		System.out.println();
		System.out.println("Old contact with id 1 and rev 2: " + oldContact);
		System.out.println();
	}
	
	private static void printContacts(String message, List<Contact> contacts) {
		System.out.printf("%n%s%n", message);
		
		for (Contact contact : contacts) {
			System.out.printf("%s%n", contact);
		}
	}
	
	private static void printAuditContacts(List<ContactAudit> contacts) {
		for (ContactAudit contact : contacts) {
			System.out.printf("%s%n", contact);
		}
	}
}
