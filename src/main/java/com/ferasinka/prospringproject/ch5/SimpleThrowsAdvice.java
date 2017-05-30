package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleThrowsAdvice implements ThrowsAdvice {
	public static void main(String[] args) {
		ErrorBean bean = new ErrorBean();
		ProxyFactory factory = new ProxyFactory(bean);
		
		factory.addAdvice(new SimpleThrowsAdvice());
		
		ErrorBean proxy = (ErrorBean) factory.getProxy();
		
		try {
			proxy.errorProneMethod();
		} catch (Exception ignored) {
		}
		
		try {
			proxy.otherErrorProneMethod();
		} catch (IllegalArgumentException ignored) {
		}
	}
	
	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("***");
		System.out.println("Generic Exception Capture");
		System.out.println("Caught: " + ex.getClass().getName());
		System.out.println("***\n");
	}
	
	public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) throws Throwable {
		System.out.println("***");
		System.out.println("IllegalArgumentException Capture");
		System.out.println("Caught: " + ex.getClass().getName());
		System.out.println("Method: " + method.getName());
		System.out.println("***\n");
	}
}
