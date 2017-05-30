package com.ferasinka.prospringproject.ch6;

import java.util.List;

public interface ContactDao {
	List<Contact> findAll();
	
	List<Contact> findByFirstName(String firstName);
	
	List<Contact> findAllWithDetail();
	
	String findLastNameById(Long id);
	
	String findFirstNameById(Long id);
	
	void insert(Contact contact);
	
	void update(Contact contact);
	
	void delete(Long contactId);
}
