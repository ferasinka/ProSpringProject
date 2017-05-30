package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {
	private SecurityManager securityManager;
	
	public SecurityAdvice() {
		this.securityManager = new SecurityManager();
	}
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		UserInfo user = securityManager.getLoggedOnUser();
		
		if (user == null) {
			System.out.println("No user authenticated");
			
			throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
		} else if ("Andrey".equals(user.getUsername())) {
			System.out.println("Logged in user is Andrey: OKAY!");
		} else {
			System.out.println("Logged in user is " + user.getUsername() + " NOT GOOD :(");
			
			throw new SecurityException("User " + user.getUsername() + " is not allowed access to method " + method.getName());
		}
	}
}
