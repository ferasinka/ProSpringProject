package com.ferasinka.prospringproject.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
	private String name;
	private int age;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch3.xml");
		
		SimpleBean parent = ctx.getBean("inheritParent", SimpleBean.class);
		SimpleBean child = ctx.getBean("inheritChild", SimpleBean.class);
		
		System.out.println("Parent: " + parent);
		System.out.println("Child: " + child);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "SimpleBean{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
