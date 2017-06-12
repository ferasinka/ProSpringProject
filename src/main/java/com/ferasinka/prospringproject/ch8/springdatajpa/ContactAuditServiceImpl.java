package com.ferasinka.prospringproject.ch8.springdatajpa;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("contactAuditService")
@Repository
@Transactional
public class ContactAuditServiceImpl implements ContactAuditService {
	private final ContactAuditRepository contactAuditRepository;
	
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
}
