package com.ferasinka.prospringproject.ch8;

import java.io.Serializable;

public class ContactSummary implements Serializable {
	private String firstName;
	private String lastName;
	private String homeTelNumber;
	
	public ContactSummary(String firstName, String lastName, String homeTelNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeTelNumber = homeTelNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getHomeTelNumber() {
		return homeTelNumber;
	}
	
	@Override
	public String toString() {
		return "First name: " + firstName + ", Last name: " + lastName + ", Home phone: " + homeTelNumber;
	}
}
