package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
	public static void main(String[] args) {
		SecurityManager manager = new SecurityManager();
		SecureBean bean = getSecureBean();
		
		manager.login("Andrey", "123");
		
		bean.writeSecureMessage();
		
		manager.logout();
		
		try {
			manager.login("Inval", "222");
			bean.writeSecureMessage();
		} catch (SecurityException e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			manager.logout();
		}
		
		try {
			bean.writeSecureMessage();
		} catch (SecurityException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	private static SecureBean getSecureBean() {
		SecureBean target = new SecureBean();
		SecurityAdvice advice = new SecurityAdvice();
		ProxyFactory factory = new ProxyFactory();
		
		factory.setTarget(target);
		factory.addAdvice(advice);
		
		return (SecureBean) factory.getProxy();
	}
}
