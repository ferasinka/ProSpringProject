package com.ferasinka.prospringproject.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimple {
	private String name;
	private int age;
	private float height;
	private boolean programer;
	private Long ageInSeconds;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch3.xml");
		InjectSimple simple = ctx.getBean("injectSimple", InjectSimple.class);
		
		System.out.println(simple);
	}
	
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
	
	@Override
	public String toString() {
		return "InjectSimple{" +
				"name='" + name + '\'' +
				", age=" + age +
				", height=" + height +
				", programer=" + programer +
				", ageInSeconds=" + ageInSeconds +
				'}';
	}
}
