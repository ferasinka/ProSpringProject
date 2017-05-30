package com.ferasinka.prospringproject.ch2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpringDI {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context-annotation-ch3.xml");
		
		MessageRenderer mr = ctx.getBean("messageRenderer", MessageRenderer.class);
		mr.render();
	}
}
