package com.ferasinka.prospringproject.ch5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProxyFactoryExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch5.xml");
		
		MyBean bean1 = ctx.getBean("myBean1", MyBean.class);
		MyBean bean2 = ctx.getBean("myBean2", MyBean.class);
		
		System.out.println("Bean 1");
		bean1.execute();
		
		System.out.println("Bean 2");
		bean2.execute();
	}
}
