package com.ferasinka.prospringproject.ch8.springdatajpa;

import com.google.common.collect.Lists;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("contactAuditService")
@Repository
@Transactional
public class ContactAuditServiceImpl implements ContactAuditService {
	private final ContactAuditRepository contactAuditRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public ContactAuditServiceImpl(ContactAuditRepository contactAuditRepository) {
		this.contactAuditRepository = contactAuditRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ContactAudit> findAll() {
		return Lists.newArrayList(contactAuditRepository.findAll());
	}
	
	@Override
	public ContactAudit findById(Long id) {
		return contactAuditRepository.findOne(id);
	}
	
	@Override
	public ContactAudit save(ContactAudit contact) {
		return contactAuditRepository.save(contact);
	}
	
	@Override
	@Transactional(readOnly = true)
	public ContactAudit findAuditByRevision(Long id, int revision) {
		AuditReader auditReader = AuditReaderFactory.get(entityManager);
		
		return auditReader.find(ContactAudit.class, id, revision);
	}
}
