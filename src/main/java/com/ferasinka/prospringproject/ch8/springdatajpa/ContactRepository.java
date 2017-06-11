package com.ferasinka.prospringproject.ch8.springdatajpa;

import com.ferasinka.prospringproject.ch8.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	List<Contact> findByFirstName(String firstName);
	
	List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
