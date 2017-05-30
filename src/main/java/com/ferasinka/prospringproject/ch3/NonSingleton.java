package com.ferasinka.prospringproject.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class NonSingleton {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch3.xml");
		
		String s1 = ctx.getBean("nonSingleton", String.class);
		String s2 = ctx.getBean("nonSingleton", String.class);
		
		System.out.println(s1 == s2);
		
		s1 = s1.intern();
		s2 = s2.intern();
		
		System.out.println(s1 == s2);
		
		System.out.println(s1.equals(s2));
	}
}
