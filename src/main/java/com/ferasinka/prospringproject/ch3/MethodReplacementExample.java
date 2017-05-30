package com.ferasinka.prospringproject.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch3.xml");
		
		ReplacementTarget replacementTarget = ctx.getBean("replacementTarget", ReplacementTarget.class);
		ReplacementTarget standardTarget = ctx.getBean("standardTarget", ReplacementTarget.class);
		
		displayInfo(replacementTarget);
		displayInfo(standardTarget);
	}
	
	private static void displayInfo(ReplacementTarget target) {
		System.out.println(target.formatMessage("Hello, world!"));
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("perfTest");
		
		for (int i = 0; i < 100_000; i++) {
			String out = target.formatMessage("foo");
		}
		
		stopWatch.stop();
		
		System.out.println("100 000 invokations took " + stopWatch.getTotalTimeMillis() + "ms");
	}
}
