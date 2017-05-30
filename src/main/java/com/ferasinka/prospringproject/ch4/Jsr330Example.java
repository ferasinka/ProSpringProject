package com.ferasinka.prospringproject.ch4;

import com.ferasinka.prospringproject.ch2.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Jsr330Example {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation-ch4.xml");
		
		MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		renderer.render();
	}
}
