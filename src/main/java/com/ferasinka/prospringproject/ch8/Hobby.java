package com.ferasinka.prospringproject.ch8;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {
	private String hobbyId;
	private Set<Contact> contacts = new HashSet<>();
	
	@Id
	@Column(name = "hobby_id")
	public String getHobbyId() {
		return hobbyId;
	}
	
	public void setHobbyId(String hobbyId) {
		this.hobbyId = hobbyId;
	}
	
	@ManyToMany
	@JoinTable(
			name = "contact_hobby_detail",
			joinColumns = @JoinColumn(name = "hobby_id"),
			inverseJoinColumns = @JoinColumn(name = "contact_id")
	)
	public Set<Contact> getContacts() {
		return contacts;
	}
	
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	
	@Override
	public String toString() {
		return "Hobby: " + getHobbyId();
	}
}
