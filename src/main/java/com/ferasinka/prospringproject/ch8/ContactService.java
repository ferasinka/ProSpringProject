package com.ferasinka.prospringproject.ch8;

import java.util.List;

public interface ContactService {
	List<Contact> findAll();
	
	List<Contact> findAllWithDetail();
	
	Contact findById(Long id);
	
	Contact save(Contact contact);
	
	void delete(Contact contact);
	
	List findAllByNativeQuery();
}
