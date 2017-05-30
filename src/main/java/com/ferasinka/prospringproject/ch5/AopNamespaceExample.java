package com.ferasinka.prospringproject.ch5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-aop.xml");
		
		MyBean myBean = ctx.getBean("myBean", MyBean.class);
		
		myBean.execute();
	}
}
