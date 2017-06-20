package com.ferasinka.prospringproject.ch10;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("contactValidator")
public class ContactValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Contact.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
	}
}
