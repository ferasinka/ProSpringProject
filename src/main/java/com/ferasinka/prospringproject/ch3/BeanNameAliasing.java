package com.ferasinka.prospringproject.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNameAliasing {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch3.xml");
		
		String s1 = ctx.getBean("name1", String.class);
		String s2 = ctx.getBean("name2", String.class);
		String s3 = ctx.getBean("name3", String.class);
		String s4 = ctx.getBean("name4", String.class);
		String s5 = ctx.getBean("name5", String.class);
		String s6 = ctx.getBean("name6", String.class);
		
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s3 == s4);
		System.out.println(s4 == s5);
		System.out.println(s5 == s6);
		
		for (String s : ctx.getAliases("name1")) {
			System.out.print(s + " ");
		}
	}
}
