package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ControlFlowExample {
	public static void main(String[] args) {
		ControlFlowExample ex = new ControlFlowExample();
		ex.run();
	}
	
	private void run() {
		TestBean target = new TestBean();
		
		Pointcut pointcut = new ControlFlowPointcut(ControlFlowExample.class, "test");
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());
		ProxyFactory factory = new ProxyFactory();
		
		factory.setTarget(target);
		factory.addAdvisor(advisor);
		
		TestBean proxy = (TestBean) factory.getProxy();
		
		System.out.println("Trying normal invoke");
		proxy.foo();
		
		System.out.println("Trying under ControlFlowExample.test()");
		test(proxy);
	}
	
	private void test(TestBean bean) {
		bean.foo();
	}
}
