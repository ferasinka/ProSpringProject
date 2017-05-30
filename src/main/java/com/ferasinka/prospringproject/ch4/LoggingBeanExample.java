package com.ferasinka.prospringproject.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class LoggingBeanExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch4.xml");
		
		BeanNamePrinter bean = ctx.getBean("beanNamePrinter", BeanNamePrinter.class);
		
		bean.someOperation();
	}
}
