package com.ferasinka.prospringproject.ch8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
	private static final Logger LOG = LoggerFactory.getLogger(ContactServiceImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAllWithDetail() {
		return em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Contact findById(Long id) {
		TypedQuery<Contact> query = em.createNamedQuery("Contact.findById", Contact.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}
	
	@Override
	public Contact save(Contact contact) {
		return null;
	}
	
	@Override
	public void delete(Contact contact) {
	
	}
}
