package com.ferasinka.prospringproject.ch14;

import org.joda.time.format.DateTimeFormat;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.IOException;

public class RuleEngineTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-ch14.xml");
		
		ContactService contactService = ctx.getBean("contactService", ContactService.class);
		
		Contact contact = new Contact();
		
		contact.setId(1L);
		contact.setFirstName("Chris");
		contact.setLastName("Schaefer");
		contact.setBirthDate(DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("1981-05-03"));
		
		contactService.applyRule(contact);
		System.out.println("Contact: " + contact);
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		contactService.applyRule(contact);
		System.out.println("Contact: " + contact);
	}
}
