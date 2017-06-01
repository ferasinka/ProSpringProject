package com.ferasinka.prospringproject.ch7;

import java.util.List;

public interface ContactDao {
	List findAll();
	
	List<Contact> findAllWithDetail();
	
	Contact findById(Long id);
	
	Contact save(Contact contact);
	
	void delete(Contact contact);
}
