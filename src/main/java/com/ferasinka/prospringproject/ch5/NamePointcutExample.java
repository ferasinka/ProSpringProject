package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class NamePointcutExample {
	public static void main(String[] args) {
		NameBean target = new NameBean();
		
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.addMethodName("foo");
		pointcut.addMethodName("bar");
		
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());
		
		ProxyFactory factory = new ProxyFactory(target);
		factory.addAdvisor(advisor);
		
		NameBean proxy = (NameBean) factory.getProxy();
		
		proxy.foo();
		proxy.foo(999);
		proxy.bar();
		proxy.yup();
	}
}
