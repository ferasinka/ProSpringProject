package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

public class ComposablePointcutExample {
	public static void main(String[] args) {
		SampleBean target = new SampleBean();
		
		ComposablePointcut pointcut = new ComposablePointcut(ClassFilter.TRUE, new GetterMethodMatcher());
		
		// Test #1
		System.out.println("Test #1");
		SampleBean proxy = getProxy(pointcut, target);
		testInvoke(proxy);
		
		// Test #2
		System.out.println("Test #2");
		pointcut.union(new SetterMethodMatcher());
		proxy = getProxy(pointcut, target);
		testInvoke(proxy);
		
		// Test #3
		System.out.println("Test #3");
		pointcut.intersection(new GetAgeMethodMatcher());
		proxy = getProxy(pointcut, target);
		testInvoke(proxy);
	}
	
	private static SampleBean getProxy(ComposablePointcut pointcut, SampleBean target) {
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());
		
		ProxyFactory factory = new ProxyFactory();
		
		factory.setTarget(target);
		factory.addAdvisor(advisor);
		
		return (SampleBean) factory.getProxy();
	}
	
	private static void testInvoke(SampleBean proxy) {
		proxy.getAge();
		proxy.getName();
		proxy.setName("Andrey Kuznetsov");
	}
	
	private static class GetterMethodMatcher extends StaticMethodMatcher {
		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return method.getName().startsWith("get");
		}
	}
	
	private static class GetAgeMethodMatcher extends StaticMethodMatcher {
		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return "getAge".equals(method.getName());
		}
	}
	
	private static class SetterMethodMatcher extends StaticMethodMatcher {
		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return method.getName().startsWith("set");
		}
	}
}
