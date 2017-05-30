package com.ferasinka.prospringproject.ch5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
	private MyDependency dependency;
	
	public void execute() {
		dependency.foo(100);
		dependency.foo(101);
		dependency.bar();
	}
	
	@Autowired
	public void setDependency(MyDependency dependency) {
		this.dependency = dependency;
	}
}
