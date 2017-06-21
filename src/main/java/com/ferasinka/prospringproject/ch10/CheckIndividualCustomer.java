package com.ferasinka.prospringproject.ch10;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = IndividualCustomerValidator.class)
public @interface CheckIndividualCustomer {
	String message() default "Individual customer should have gender and last name defined";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
