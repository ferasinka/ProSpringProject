package com.ferasinka.prospringproject.ch10;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service("myBeanValidationService")
public class MyBeanValidationService {
	private final Validator validator;
	
	@Inject
	public MyBeanValidationService(Validator validator) {
		this.validator = validator;
	}
	
	public Set<ConstraintViolation<Customer>> validateCustomer(Customer customer) {
		return validator.validate(customer);
	}
}
