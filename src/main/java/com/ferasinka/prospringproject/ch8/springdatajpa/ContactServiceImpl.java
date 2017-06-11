package com.ferasinka.prospringproject.ch8.springdatajpa;

import com.ferasinka.prospringproject.ch8.Contact;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("springJpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
	private final ContactRepository contactRepository;
	
	@Autowired
	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findByFirstName(String firstName) {
		return contactRepository.findByFirstName(firstName);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
		return contactRepository.findByFirstNameAndLastName(firstName, lastName);
	}
}
