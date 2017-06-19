package com.ferasinka.prospringproject.ch9.xmlconfig;

import java.util.List;

public interface ContactService {
	List<Contact> findAll();
	
	Contact findById(Long id);
	
	Contact save(Contact contact);
	
	long countAll();
}
