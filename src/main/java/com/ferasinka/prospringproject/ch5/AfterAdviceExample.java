package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceExample {
	public static void main(String[] args) {
		KeyGenerator keyGenerator = new KeyGenerator();
		
		ProxyFactory pf = new ProxyFactory(keyGenerator);
		pf.addAdvice(new WeakKeyCheckAdvice());
		
		KeyGenerator proxy = (KeyGenerator) pf.getProxy();
		
		for (int i = 0; i < 10; i++) {
			try {
				long key = proxy.getKey();
				
				System.out.println("Key: " + key);
			} catch (SecurityException e) {
				System.out.println("Weak key has been generated!");
			}
		}
	}
}
