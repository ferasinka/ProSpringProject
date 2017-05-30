package com.ferasinka.prospringproject.ch4;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNamePrinter implements BeanNameAware {
	private String beanName;
	
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}
	
	public void someOperation() {
		System.out.println("Bean [" + beanName + "] - someOperation()");
	}
}
