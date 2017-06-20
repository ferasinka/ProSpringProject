package com.ferasinka.prospringproject.ch10;

import org.springframework.core.convert.converter.Converter;

public class ContactToAnotherContactConverter implements Converter<Contact, AnotherContact> {
	@Override
	public AnotherContact convert(Contact source) {
		AnotherContact anotherContact = new AnotherContact();
		
		anotherContact.setFirstName(source.getLastName());
		anotherContact.setLastName(source.getFirstName());
		anotherContact.setBirthDate(source.getBirthDate());
		anotherContact.setPersonalSite(source.getPersonalSite());
		
		return anotherContact;
	}
}
