package com.ferasinka.prospringproject.ch8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
	private static final Logger LOG = LoggerFactory.getLogger(ContactServiceImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Contact> findAll() {
		return null;
	}
	
	@Override
	public List<Contact> findAllWithDetail() {
		return null;
	}
	
	@Override
	public Contact findById(Long id) {
		return null;
	}
	
	@Override
	public Contact save(Contact contact) {
		return null;
	}
	
	@Override
	public void delete(Contact contact) {
	
	}
}
