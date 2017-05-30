package com.ferasinka.prospringproject.ch3.xml;

import com.ferasinka.prospringproject.ch3.Bar;
import com.ferasinka.prospringproject.ch3.Foo;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {
	private Foo foo;
	private Foo foo2;
	private Bar bar;
	
	public Target() {
	}
	
	public Target(Foo foo) {
		System.out.println("Target(Foo) called");
	}
	
	public Target(Foo foo, Bar bar) {
		System.out.println("Target(Foo, Bar) called");
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch3.xml");
		
		Target t = null;
		
		System.out.println("Using byName:");
		t = ctx.getBean("targetByName", Target.class);
		System.out.println();
		
		System.out.println("Using byType:");
		t = ctx.getBean("targetByType", Target.class);
		System.out.println();
		
		System.out.println("Using constructor:");
		t = ctx.getBean("targetConstructor", Target.class);
		System.out.println();
	}
	
	public void setFoo(Foo foo) {
		this.foo = foo;
		System.out.println("Property foo set");
	}
	
	public void setFoo2(Foo foo) {
		this.foo2 = foo;
		System.out.println("Property foo2 set");
	}
	
	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("Property bar set");
	}
}
