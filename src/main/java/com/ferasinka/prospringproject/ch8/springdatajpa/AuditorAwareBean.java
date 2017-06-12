package com.ferasinka.prospringproject.ch8.springdatajpa;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareBean implements AuditorAware<String> {
	@Override
	public String getCurrentAuditor() {
		return "prospring4";
	}
}
