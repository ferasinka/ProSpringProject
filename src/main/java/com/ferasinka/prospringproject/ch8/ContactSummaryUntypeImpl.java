package com.ferasinka.prospringproject.ch8;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

@Service("contactSummaryUntype")
@Repository
@Transactional
public class ContactSummaryUntypeImpl {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	public void displayAllContactSummary() {
		List result = em.createQuery(
				"select c.firstName, c.lastName, t.telNumber " +
						"from Contact c left join c.contactTelDetails t " +
						"where t.telType = 'Home'")
				.getResultList();
		
		int count = 0;
		
		for (Object res : result) {
			Object[] values = (Object[]) res;
			
			System.out.println(++count + ": " + values[0] + ", " + values[1] + ", " + values[2]);
		}
	}
}
