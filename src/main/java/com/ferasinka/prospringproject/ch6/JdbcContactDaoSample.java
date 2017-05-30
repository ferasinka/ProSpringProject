package com.ferasinka.prospringproject.ch6;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcContactDaoSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch6.xml");
		
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		
		System.out.println("Frist name for contact id 1 is: " + contactDao.findFirstNameById(1L));
		System.out.println("Last name for contact id 1 is: " + contactDao.findLastNameById(1L));
		
	}
}
