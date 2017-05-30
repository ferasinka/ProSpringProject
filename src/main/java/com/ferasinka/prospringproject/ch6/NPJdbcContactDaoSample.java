package com.ferasinka.prospringproject.ch6;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class NPJdbcContactDaoSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch6.xml");
		
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		
		List<Contact> contacts = contactDao.findAllWithDetail();
		
		for (Contact contact : contacts) {
			System.out.println(contact);
			
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
					System.out.println("---" + contactTelDetail);
				}
			}
		}
	}
}
