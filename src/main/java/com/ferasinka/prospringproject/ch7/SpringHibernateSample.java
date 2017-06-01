package com.ferasinka.prospringproject.ch7;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class SpringHibernateSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation-ch7.xml");
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		
		Contact contact = new Contact();
		
		// ----- Insert -----
		
		contact.setFirstName("Andrey");
		contact.setLastName("Kuznetsov");
		contact.setBirthDate(new Date());
		
		ContactTelDetail contactTelDetail = new ContactTelDetail("Home", "7774567");
		
		contact.addContactTelDetail(contactTelDetail);
		
		contactTelDetail = new ContactTelDetail("Mobile", "9991234567");
		
		contact.addContactTelDetail(contactTelDetail);
		
		contactDao.save(contact);
		
		// ----- Update -----
		
		contact = contactDao.findById(1L);
		contact.setFirstName("Kim Fung");
		
		Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
		
		ContactTelDetail toDeleteContactTel = null;
		
		for (ContactTelDetail contactTel : contactTels) {
			if ("Home".equals(contactTel.getTelType())) {
				toDeleteContactTel = contactTel;
			}
		}
		
		printContactsWithDetails(contactDao.findAllWithDetail());
		
		contact.removeContactTelDetail(toDeleteContactTel);
		
		contactDao.save(contact);
		
		// ----- Delete -----
		
		contact = contactDao.findById(1L);
		
		contactDao.delete(contact);
		
		printContactsWithDetails(contactDao.findAllWithDetail());
	}
	
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
	
	private static void printContacts(List<Contact> contacts) {
		System.out.println();
		System.out.println("Listing contacts without details: ");
		
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
}
