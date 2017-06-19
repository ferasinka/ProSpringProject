package com.ferasinka.prospringproject.ch9.progconfig;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contact")
@NamedQueries({
		@NamedQuery(name = "Contact.findAll", query = "select c from Contact c"),
		@NamedQuery(name = "Contact.countAll", query = "select count(c) from Contact c")
})
public class Contact implements Serializable {
	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private Date birthDate;
	
	public Contact() {
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
	
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "Contact - id: " + id + ", First name: " + firstName + ", Last name: " + lastName + ", Birthday: " + birthDate;
	}
}
