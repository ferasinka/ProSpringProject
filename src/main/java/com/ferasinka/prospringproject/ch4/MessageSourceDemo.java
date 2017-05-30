package com.ferasinka.prospringproject.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

public class MessageSourceDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("spring/app-context-xml-ch4.xml");
		ctx.refresh();
		
		Locale english = Locale.ENGLISH;
		Locale russian = new Locale("ru");
		
		System.out.println(ctx.getMessage("msg", null, english));
		System.out.println(ctx.getMessage("msg", null, russian));
		
		System.out.println(ctx.getMessage("nameMsg", new Object[]{"Andrey", "Kuznetsov"}, english));
	}
}
