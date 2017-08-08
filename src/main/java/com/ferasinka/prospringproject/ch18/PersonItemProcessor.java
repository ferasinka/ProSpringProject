package com.ferasinka.prospringproject.ch18;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {
	private static final Logger LOG = LoggerFactory.getLogger(PersonItemProcessor.class);
	
	@Override
	public Person process(Person person) throws Exception {
		String firstName = person.getFirstName().toUpperCase();
		String lastName = person.getLastName().toUpperCase();
		
		Person transformedPerson = new Person();
		
		transformedPerson.setFirstName(firstName);
		transformedPerson.setLastName(lastName);
		
		LOG.info("Transformed person: " + person + ", into: " + transformedPerson);
		
		return transformedPerson;
	}
}
