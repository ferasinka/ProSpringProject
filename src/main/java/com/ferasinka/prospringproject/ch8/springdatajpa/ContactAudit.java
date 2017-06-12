package com.ferasinka.prospringproject.ch8.springdatajpa;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contact_audit")
public class ContactAudit implements Auditable<String, Long>, Serializable {
	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String createdBy;
	private DateTime createdDate;
	private String lastModifiedBy;
	private DateTime lastModifiedDate;
	
	@Id
	@Override
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Version
	@Column(name = "version")
	public int getVersion() {
		return this.version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Column(name = "first_name")
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name")
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return this.birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	@Column(name = "created_by")
	public String getCreatedBy() {
		return this.createdBy;
	}
	
	@Override
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Override
	@Column(name = "created_date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getCreatedDate() {
		return this.createdDate;
	}
	
	@Override
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	@Column(name = "last_modified_by")
	public String getLastModifiedBy() {
		return this.lastModifiedBy;
	}
	
	@Override
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	
	@Override
	@Column(name = "last_modified_date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getLastModifiedDate() {
		return this.lastModifiedDate;
	}
	
	@Override
	public void setLastModifiedDate(DateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	@Override
	@Transient
	public boolean isNew() {
		return id == null;
	}
	
	@Override
	public String toString() {
		return "Contact id: " + id +
				", First name: " + firstName +
				", Last name: " + lastName +
				", Birthday: " + birthDate +
				", Created by: " + createdBy +
				", Created date: " + createdDate +
				", Modified by: " + lastModifiedBy +
				", Modified date: " + lastModifiedDate;
	}
}
