package com.ferasinka.prospringproject.ch8.springdatajpa;

import org.springframework.data.repository.CrudRepository;

public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {
}
