package com.ferasinka.prospringproject.ch10;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class Jsr349Sample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/jsr349-app-context-ch10.xml");
		
		MyBeanValidationService myBeanValidationService = ctx.getBean("myBeanValidationService", MyBeanValidationService.class);
		
		Customer customer = new Customer();
		
		customer.setFirstName("C");
		customer.setLastName("Schaefer");
		customer.setCustomerType(null);
		customer.setGender(null);
		
		validateCustomer(customer, myBeanValidationService);
		
		// ------------------------------
		
		customer.setFirstName("Chris");
		customer.setLastName("Schaefer");
		customer.setCustomerType(CustomerType.INDIVIDUAL);
		customer.setGender(null);
		
		validateCustomer(customer, myBeanValidationService);
	}
	
	private static void validateCustomer(Customer customer, MyBeanValidationService myBeanValidationService) {
		Set<ConstraintViolation<Customer>> violations = myBeanValidationService.validateCustomer(customer);
		
		listViolations(violations);
	}
	
	private static void listViolations(Set<ConstraintViolation<Customer>> violations) {
		System.out.println("No of violations: " + violations.size());
		
		for (ConstraintViolation<Customer> violation : violations) {
			System.out.println("Validation error for property: " + violation.getPropertyPath() + " with value: " + violation.getInvalidValue() + " with error message: " + violation.getMessage());
		}
	}
}
