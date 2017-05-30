package com.ferasinka.prospringproject.ch5;

public class SampleAnnotationBean {
	@AdviceRequired
	public void foo(int x) {
		System.out.println("Invoked foo(int) with: " + x);
	}
	
	public void bar() {
		System.out.println("Invoked bar()");
	}
}
