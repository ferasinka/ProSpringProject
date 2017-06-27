package com.ferasinka.prospringproject.ch11;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ScheduleTaskSample {
	public static void main(String[] args) throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/task-namespace-app-context-ch11.xml");
		
		while (true) {
			Thread.sleep(1000);
		}
	}
}
