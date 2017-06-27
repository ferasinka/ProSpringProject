package com.ferasinka.prospringproject.ch11;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.concurrent.Future;

public class AsyncTaskSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/async-app-context-ch11.xml");
		
		AsyncService asyncService = ctx.getBean("asyncService", AsyncService.class);
		
		for (int i = 0; i < 5; i++) {
			asyncService.asyncTask();
		}
		
		Future<String> result1 = asyncService.asyncWithReturn("Chris");
		Future<String> result2 = asyncService.asyncWithReturn("John");
		Future<String> result3 = asyncService.asyncWithReturn("Robert");
		
		try {
			Thread.sleep(6000);
			
			System.out.println("Result1: " + result1.get());
			System.out.println("Result2: " + result2.get());
			System.out.println("Result3: " + result3.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
