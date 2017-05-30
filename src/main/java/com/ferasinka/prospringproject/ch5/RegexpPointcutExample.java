package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

public class RegexpPointcutExample {
	public static void main(String[] args) {
		RegexpBean target = new RegexpBean();
		
		JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
		pointcut.setPattern(".*foo.*");
		
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());
		
		ProxyFactory factory = new ProxyFactory(target);
		factory.addAdvisor(advisor);
		
		RegexpBean proxy = (RegexpBean) factory.getProxy();
		
		proxy.foo1();
		proxy.foo2();
		proxy.bar();
	}
}
