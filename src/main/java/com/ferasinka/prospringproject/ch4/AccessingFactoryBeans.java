package com.ferasinka.prospringproject.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

public class AccessingFactoryBeans {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch4.xml");
		
		MessageDigest digest = ctx.getBean("shaDigest", MessageDigest.class);
		MessageDigestFactoryBean factoryBean = ctx.getBean("&shaDigest", MessageDigestFactoryBean.class);
		
		try {
			MessageDigest shaDigest = factoryBean.getObject();
			
			System.out.println(shaDigest.digest("Hello, world!".getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
