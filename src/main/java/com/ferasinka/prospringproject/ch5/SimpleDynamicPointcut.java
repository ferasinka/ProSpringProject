package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("Static check for " + method.getName());
		
		return "foo".equals(method.getName());
	}
	
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		System.out.println("Dynamic check for " + method.getName());
		
		int x = (Integer) args[0];
		
		return x != 100;
	}
	
	@Override
	public ClassFilter getClassFilter() {
		return clazz -> clazz == SampleBean.class;
	}
}
