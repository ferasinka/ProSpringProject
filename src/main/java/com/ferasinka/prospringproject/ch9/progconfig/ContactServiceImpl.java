package com.ferasinka.prospringproject.ch9.progconfig;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Service("contactService")
public class ContactServiceImpl implements ContactService {
	private ContactRepository contactRepository;
	private TransactionTemplate transactionTemplate;
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	public void setContactRepository(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	@Override
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}
	
	@Override
	public Contact findById(Long id) {
		return contactRepository.findOne(id);
	}
	
	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}
	
	@Override
	public long countAll() {
		return transactionTemplate.execute(status -> em.createNamedQuery("Contact.countAll", Long.class).getSingleResult());
	}
}
