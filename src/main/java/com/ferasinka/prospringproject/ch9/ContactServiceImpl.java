package com.ferasinka.prospringproject.ch9;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Service("contactService")
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
	public Contact findById(Long id) {
		return contactRepository.findOne(id);
	}
	
	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}
	
	@Override
	@Transactional(propagation = Propagation.NEVER)
	public long countAll() {
		return contactRepository.countAllContacts();
	}
}
