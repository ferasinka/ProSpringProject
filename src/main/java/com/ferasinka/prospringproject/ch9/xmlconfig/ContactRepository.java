package com.ferasinka.prospringproject.ch9.xmlconfig;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	@Query("select count(c) from Contact c")
	Long countAllContacts();
}
