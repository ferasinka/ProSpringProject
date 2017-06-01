package com.ferasinka.prospringproject.ch7;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact_tel_detail")
public class ContactTelDetail implements Serializable {
	private Long id;
	private int version;
	private String telType;
	private String telNumber;
	private Contact contact;
	
	public ContactTelDetail() {
	}
	
	public ContactTelDetail(String telType, String telNumber) {
		this.telType = telType;
		this.telNumber = telNumber;
	}
	
	@ManyToOne
	@JoinColumn(name = "contact_id")
	public Contact getContact() {
		return contact;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Version
	@Column(name = "version")
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Column(name = "tel_type")
	public String getTelType() {
		return telType;
	}
	
	public void setTelType(String telType) {
		this.telType = telType;
	}
	
	@Column(name = "tel_number")
	public String getTelNumber() {
		return telNumber;
	}
	
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	@Override
	public String toString() {
		return "Contact Tel Detail - id: " + id + ", Contact id: " + getContact().getId() + ", Type: " + telType + ", Number: " + telNumber + "\n";
	}
}
