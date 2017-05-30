package com.ferasinka.prospringproject.ch5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation-aop.xml");
		
		MyBean myBean = ctx.getBean("myBean", MyBean.class);
		myBean.execute();
	}
}
