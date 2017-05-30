package com.ferasinka.prospringproject.ch4;

import com.ferasinka.prospringproject.ch2.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigXmlExample {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context-xml-ch3.xml");
		
		MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		
		renderer.render();
	}
}
