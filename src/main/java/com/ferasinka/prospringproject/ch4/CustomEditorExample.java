package com.ferasinka.prospringproject.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomEditorExample {
	private Name name;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch4.xml");
		
		CustomEditorExample bean = ctx.getBean("exampleBean", CustomEditorExample.class);
		
		System.out.println(bean.getName());
	}
	
	public Name getName() {
		return name;
	}
	
	public void setName(Name name) {
		this.name = name;
	}
}
