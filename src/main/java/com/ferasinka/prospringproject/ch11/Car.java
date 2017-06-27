package com.ferasinka.prospringproject.ch11;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
public class Car implements Serializable {
	private Long id;
	private String licensePlate;
	private String manufacturer;
	private DateTime manufactureDate;
	private int age;
	private int version;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "license_plate")
	public String getLicensePlate() {
		return licensePlate;
	}
	
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	@Column(name = "manufacturer")
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Column(name = "manufacture_date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getManufactureDate() {
		return manufactureDate;
	}
	
	public void setManufactureDate(DateTime manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Column(name = "age")
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Version
	@Column(name = "version")
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		return "License: " + licensePlate +
				", Manufacturer: " + manufacturer +
				", Manufacture date: " + manufactureDate +
				", Age: " + age;
	}
}
