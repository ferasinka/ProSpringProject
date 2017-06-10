package com.ferasinka.prospringproject.ch8;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class SpringJpaSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation-ch8.xml");
		
		ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);

//		printContacts(contactService.findAll());
//		------------------------
//		printContactsWithDetails(contactService.findAllWithDetail());
//		------------------------
//		System.out.println(contactService.findById(1L));
//		------------------------
//		ContactSummaryUntypeImpl contactSummaryUntype = ctx.getBean("contactSummaryUntype", ContactSummaryUntypeImpl.class);
//		contactSummaryUntype.displayAllContactSummary();
// 		------------------------
//		ContactSummaryService contactSummaryService = ctx.getBean("contactSummaryService", ContactSummaryService.class);
//		List<ContactSummary> contacts = contactSummaryService.findAll();
//
//		for (ContactSummary contact : contacts) {
//			System.out.println(contact);
//		}
// 		------------------------
//		Contact contact = new Contact();
//		contact.setFirstName("Michael");
//		contact.setLastName("Jackson");
//		contact.setBirthDate(new Date());
//
//		contact.addContactTelDetail(new ContactTelDetail("Home", "1111111"));
//		contact.addContactTelDetail(new ContactTelDetail("Mobile", "2222222"));
//
//		contactService.save(contact);
//
//		printContactsWithDetails(contactService.findAllWithDetail());
// 		------------------------
//		Contact contact = contactService.findById(1L);
//
//		System.out.println();
//		System.out.println("Contact with id 1: " + contact);
//		System.out.println();
//
//		contact.setFirstName("Justin");
//
//		Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
//		ContactTelDetail toDeleteContactTel = null;
//
//		for (ContactTelDetail contactTel : contactTels) {
//			if (contactTel.getTelType().equals("Home")) {
//				toDeleteContactTel = contactTel;
//			}
//		}
//
//		contactTels.remove(toDeleteContactTel);
//		contactService.save(contact);
//
//		printContactsWithDetails(contactService.findAllWithDetail());
// 		------------------------
//		Contact contact = contactService.findById(1L);
//
//		contactService.delete(contact);
//
//		printContactsWithDetails(contactService.findAllWithDetail());
// 		------------------------
		List<Contact> contacts = contactService.findByCriteriaQuery("John", "Smith");
		printContactsWithDetails(contacts);
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
