package com.ferasinka.prospringproject.ch6;

import java.io.Serializable;

public class ContactTelDetail implements Serializable {
	private Long id;
	private Long contactId;
	private String telType;
	private String telNumber;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getContactId() {
		return contactId;
	}
	
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	
	public String getTelType() {
		return telType;
	}
	
	public void setTelType(String telType) {
		this.telType = telType;
	}
	
	public String getTelNumber() {
		return telNumber;
	}
	
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	@Override
	public String toString() {
		return "ContactTelDetail{" +
				"id=" + id +
				", contactId=" + contactId +
				", telType='" + telType + '\'' +
				", telNumber='" + telNumber + '\'' +
				'}';
	}
}
