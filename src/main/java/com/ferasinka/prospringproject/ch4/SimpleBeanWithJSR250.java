package com.ferasinka.prospringproject.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

public class SimpleBeanWithJSR250 {
	private static final String DEFAULT_NAME = "Luke Skywalker";
	
	private String name;
	private int age = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation-ch4.xml");
		
		SimpleBeanWithJSR250 simpleBean1 = getBean("simpleBean1", ctx);
		SimpleBeanWithJSR250 simpleBean2 = getBean("simpleBean2", ctx);
		SimpleBeanWithJSR250 simpleBean3 = getBean("simpleBean3", ctx);
	}
	
	private static SimpleBeanWithJSR250 getBean(String beanName, ApplicationContext ctx) {
		try {
			SimpleBeanWithJSR250 bean = ctx.getBean(beanName, SimpleBeanWithJSR250.class);
			System.out.println(bean);
			
			return bean;
		} catch (BeanCreationException e) {
			System.out.println("An error occured in bean configuration: " + e.getMessage());
		}
		
		return null;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@PostConstruct
	public void init() throws Exception {
		System.out.println("Initializing bean");
		
		if (name == null) {
			System.out.println("Using defalut name");
			name = DEFAULT_NAME;
		}
		
		if (age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("You must set the age property of any beans of type " + SimpleBeanWithJSR250.class);
		}
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s%nAge: %s", name, age);
	}
}
