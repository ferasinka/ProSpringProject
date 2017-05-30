package com.ferasinka.prospringproject.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class ProfileXmlConfigExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("*-config.xml");
		ctx.getEnvironment().addActiveProfile("highschool");
		
		FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
		
		List<Food> lunchSet = foodProviderService.provideLunchSet();
		
		for (Food food : lunchSet) {
			System.out.println("Food: " + food.getName());
		}
	}
}
