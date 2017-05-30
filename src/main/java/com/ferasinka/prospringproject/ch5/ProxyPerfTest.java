package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ProxyPerfTest {
	private static final int INT = 500_000;
	
	public static void main(String[] args) {
		SimpleBean target = new DefaultSimpleBean();
		
		Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(), new NoOpBeforeAdvice());
		
		runCglibTests(advisor, target);
		runCglibFrozenTests(advisor, target);
		runJdkTests(advisor, target);
	}
	
	private static void runCglibTests(Advisor advisor, SimpleBean target) {
		ProxyFactory factory = new ProxyFactory(target);
		
		factory.setProxyTargetClass(true);
		factory.addAdvisor(advisor);
		
		SimpleBean proxy = (SimpleBean) factory.getProxy();
		
		System.out.println("Running CGLIB (Standard) tests");
		test(proxy);
	}
	
	private static void runCglibFrozenTests(Advisor advisor, SimpleBean target) {
		ProxyFactory factory = new ProxyFactory(target);
		
		factory.setProxyTargetClass(true);
		factory.addAdvisor(advisor);
		factory.setFrozen(true);
		
		SimpleBean proxy = (SimpleBean) factory.getProxy();
		
		System.out.println("Running CGLIB (Frozen) tests");
		test(proxy);
	}
	
	private static void runJdkTests(Advisor advisor, SimpleBean target) {
		ProxyFactory factory = new ProxyFactory(target);
		
		factory.setProxyTargetClass(true);
		factory.addAdvisor(advisor);
		factory.setInterfaces(SimpleBean.class);
		
		SimpleBean proxy = (SimpleBean) factory.getProxy();
		
		System.out.println("Running JDK tests");
		test(proxy);
	}
	
	private static void test(SimpleBean bean) {
		long before;
		long after;
		
		System.out.println("Testing advised method");
		before = System.currentTimeMillis();
		
		for (int i = 0; i < INT; i++) {
			bean.advised();
		}
		
		after = System.currentTimeMillis();
		
		System.out.println("Took " + (after - before) + "ms");
		
		// -----
		
		System.out.println("Testing unadvised method");
		before = System.currentTimeMillis();
		
		for (int i = 0; i < INT; i++) {
			bean.unadvised();
		}
		
		after = System.currentTimeMillis();
		
		System.out.println("Took " + (after - before) + "ms");
		
		// -----
		
		System.out.println("Testing equals() method");
		before = System.currentTimeMillis();
		
		for (int i = 0; i < INT; i++) {
			bean.equals(bean);
		}
		
		after = System.currentTimeMillis();
		
		System.out.println("Took " + (after - before) + "ms");
		
		// -----
		
		System.out.println("Testing hashcode() method");
		before = System.currentTimeMillis();
		
		for (int i = 0; i < INT; i++) {
			bean.hashCode();
		}
		
		after = System.currentTimeMillis();
		
		System.out.println("Took " + (after - before) + "ms");
		
		// -----
		
		Advised advised = (Advised) bean;
		
		System.out.println("Testing Advised.getTargetClass() method");
		before = System.currentTimeMillis();
		
		for (int i = 0; i < INT; i++) {
			advised.getTargetClass();
		}
		
		after = System.currentTimeMillis();
		
		System.out.println("Took " + (after - before) + "ms");
		
		System.out.println(">>>\n");
	}
}
