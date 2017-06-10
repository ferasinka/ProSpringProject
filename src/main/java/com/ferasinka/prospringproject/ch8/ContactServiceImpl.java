package com.ferasinka.prospringproject.ch8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
	private final static String ALL_CONTACT_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from contact";
	
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
		return em.createNamedQuery("Contact.findById", Contact.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	@Override
	public Contact save(Contact contact) {
		if (contact.getId() == null) {
			LOG.info("Inserting new contact");
			
			em.persist(contact);
		} else {
			em.merge(contact);
			
			LOG.info("Updating existing contact");
		}
		
		LOG.info("Contact saved with id: " + contact.getId());
		
		return contact;
	}
	
	@Override
	public void delete(Contact contact) {
		Contact mergedContact = em.merge(contact);
		em.remove(mergedContact);
		
		LOG.info("Contact with id: " + contact.getId() + " deleted successfully");
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Contact> findAllByNativeQuery() {
//		return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, Contact.class).getResultList();
		
		return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, "contactResult").getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findByCriteriaQuery(String firstName, String lastName) {
		LOG.info("Finding contact for first name: " + firstName + " and last name: " + lastName);
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Contact> criteriaQuery = cb.createQuery(Contact.class);
		Root<Contact> contactRoot = criteriaQuery.from(Contact.class);
		
		contactRoot.fetch(Contact_.contactTelDetails, JoinType.LEFT);
		contactRoot.fetch(Contact_.hobbies, JoinType.LEFT);
		
		criteriaQuery.select(contactRoot).distinct(true);
		
		Predicate criteria = cb.conjunction();
		
		if (firstName != null) {
			Predicate p = cb.equal(contactRoot.get(Contact_.firstName), firstName);
			criteria = cb.and(criteria, p);
		}
		
		if (lastName != null) {
			Predicate p = cb.equal(contactRoot.get(Contact_.lastName), lastName);
			criteria = cb.and(criteria, p);
		}
		
		criteriaQuery.where(criteria);
		
		return em.createQuery(criteriaQuery).getResultList();
	}
}
