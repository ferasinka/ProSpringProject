package com.ferasinka.prospringproject.ch12;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

public class RestfulClientSample {
	private static final String URL_GET_ALL_CONTACTS = "http://localhost:8080/restful/contact/listdata";
	private static final String URL_GET_CONTACT_BY_ID = "http://localhost:8080/restful/contact/{id}";
	private static final String URL_CREATE_CONTACT = "http://localhost:8080/restful/contact/";
	private static final String URL_UPDATE_CONTACT = "http://localhost:8080/restful/contact/{id}";
	private static final String URL_DELETE_CONTACT = "http://localhost:8080/restful/contact/{id}";
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/restful-client-app-context-ch12.xml");
		
		RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);
		
		System.out.println("Testing retrieve all contacts:");
		
		Contacts contacts = restTemplate.getForObject(URL_GET_ALL_CONTACTS, Contacts.class);
		
		for (Contact contact : contacts.getContacts()) {
			System.out.println(contact);
		}
		
		System.out.println();
	}
}
