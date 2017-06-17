package com.ferasinka.prospringproject.ch8.springdatajpa;

import java.util.List;

public interface ContactAuditService {
	List<ContactAudit> findAll();
	
	ContactAudit findById(Long id);
	
	ContactAudit save(ContactAudit contact);
	
	ContactAudit findAuditByRevision(Long id, int revision);
}
