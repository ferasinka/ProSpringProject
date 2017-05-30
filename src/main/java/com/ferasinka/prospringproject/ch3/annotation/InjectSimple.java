package com.ferasinka.prospringproject.ch3.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {
	@Value("#{injectSimpleConfig.name}")
	private String name;
	
	@Value("#{injectSimpleConfig.age + 1}")
	private int age;
	
	@Value("#{injectSimpleConfig.height}")
	private float height;
	
	@Value("#{injectSimpleConfig.programer}")
	private boolean programer;
	
	@Value("#{injectSimpleConfig.ageInSeconds}")
	private Long ageInSeconds;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("spring/app-context-annotation-ch3.xml");
		ctx.refresh();
		
		InjectSimple simple = (InjectSimple) ctx.getBean("injectSimple");
		
		System.out.println(simple);
	}
	
	@Override
	public String toString() {
		return "InjectSimple{" +
				"name='" + name + '\'' +
				", age=" + age +
				", height=" + height +
				", programer=" + programer +
				", ageInSeconds=" + ageInSeconds +
				'}';
	}
}
