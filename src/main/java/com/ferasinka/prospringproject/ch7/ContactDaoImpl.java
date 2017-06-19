package com.ferasinka.prospringproject.ch7;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("contactDao")
@SuppressWarnings("unchecked")
public class ContactDaoImpl implements ContactDao {
	private static final Logger LOG = LoggerFactory.getLogger(ContactDaoImpl.class);
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAllWithDetail() {
		return sessionFactory.getCurrentSession().getNamedQuery("Contact.findAllWithDetail").list();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Contact findById(Long id) {
		return (Contact) sessionFactory.getCurrentSession().getNamedQuery("Contact.findById").setParameter("id", id).uniqueResult();
	}
	
	@Override
	public Contact save(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		
		LOG.info("Contact saved with id: " + contact.getId());
		
		return contact;
	}
	
	@Override
	public void delete(Contact contact) {
		sessionFactory.getCurrentSession().delete(contact);
		
		LOG.info("Contact deleted with id: " + contact.getId());
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
