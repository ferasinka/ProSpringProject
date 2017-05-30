package com.ferasinka.prospringproject.ch4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Publisher implements ApplicationContextAware {
	private ApplicationContext ctx;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context-xml-ch4.xml");
		
		Publisher pub = ctx.getBean("publisher", Publisher.class);
		
		pub.publish("Hello, world!");
		pub.publish("My name is Andrey Kuznetsov");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}
	
	public void publish(String message) {
		ctx.publishEvent(new MessageEvent(this, message));
	}
}
