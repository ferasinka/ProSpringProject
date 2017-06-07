package com.ferasinka.prospringproject.ch8;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("contactSummaryService")
@Repository
@Transactional
public class ContactSummaryServiceImpl implements ContactSummaryService {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public List<ContactSummary> findAll() {
		return em.createQuery(
				"select new com.ferasinka.prospringproject.ch8.ContactSummary(" +
						"c.firstName, c.lastName, t.telNumber) " +
						"from Contact c left join c.contactTelDetails t " +
						"where t.telType = 'Home'", ContactSummary.class)
				.getResultList();
	}
}
