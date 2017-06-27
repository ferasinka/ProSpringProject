package com.ferasinka.prospringproject.ch11;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TaskExecutorSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-ch11.xml");
		
		TaskToExecute taskToExecute = ctx.getBean(TaskToExecute.class);
		
		taskToExecute.executeTask();
	}
}
