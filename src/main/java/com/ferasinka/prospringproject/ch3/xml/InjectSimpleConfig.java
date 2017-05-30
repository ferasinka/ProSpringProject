package com.ferasinka.prospringproject.ch3.xml;

public class InjectSimpleConfig {
	private String name = "Andrey Kuznetsov";
	private int age = 28;
	private float height = 76.5F;
	private boolean programer = true;
	private Long ageInSeconds = 100500L;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public boolean isProgramer() {
		return programer;
	}
	
	public void setProgramer(boolean programer) {
		this.programer = programer;
	}
	
	public Long getAgeInSeconds() {
		return ageInSeconds;
	}
	
	public void setAgeInSeconds(Long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}
}
