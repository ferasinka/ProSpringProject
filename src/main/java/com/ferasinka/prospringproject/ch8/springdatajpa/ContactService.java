package com.ferasinka.prospringproject.ch8.springdatajpa;

import com.ferasinka.prospringproject.ch8.Contact;

import java.util.List;

public interface ContactService {
	List<Contact> findAll();
	
	List<Contact> findByFirstName(String firstName);
	
	List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
