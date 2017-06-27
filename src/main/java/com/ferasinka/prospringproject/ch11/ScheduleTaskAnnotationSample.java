package com.ferasinka.prospringproject.ch11;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ScheduleTaskAnnotationSample {
	public static void main(String[] args) throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/task-annotation-app-context-ch11.xml");
		
		while (true) {
			Thread.sleep(1000);
		}
	}
}
