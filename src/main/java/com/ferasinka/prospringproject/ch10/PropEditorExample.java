package com.ferasinka.prospringproject.ch10;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PropEditorExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/prop-editor-app-context-ch10.xml");
		
		Contact chris = ctx.getBean("chris", Contact.class);
		System.out.println(chris);
		
		System.out.println();
		
		Contact myContact = ctx.getBean("myContact", Contact.class);
		System.out.println(myContact);
	}
}
