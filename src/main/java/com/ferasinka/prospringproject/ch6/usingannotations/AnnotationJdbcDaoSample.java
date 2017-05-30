package com.ferasinka.prospringproject.ch6.usingannotations;

import com.ferasinka.prospringproject.ch6.Contact;
import com.ferasinka.prospringproject.ch6.ContactTelDetail;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class AnnotationJdbcDaoSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation-ch6.xml");
		
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		
		System.out.println(contactDao.findFirstNameById(1L));

//		printContacts(contactDao.findAllWithDetail());
	}
	
	private static void printContacts(List<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact);
			
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
					System.out.println("---" + contactTelDetail);
				}
			}
			
			System.out.println();
		}
	}
}
