package com.ferasinka.prospringproject.ch5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutExample {
	public static void main(String[] args) {
		BeanOne beanOne = new BeanOne();
		BeanTwo beanTwo = new BeanTwo();
		
		BeanOne proxyOne;
		BeanTwo proxyTwo;
		
		Pointcut pc = new SimpleStaticPointcut();
		Advice advice = new SimpleAdvice();
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
		
		ProxyFactory pf = new ProxyFactory(beanOne);
		pf.addAdvisor(advisor);
		proxyOne = (BeanOne) pf.getProxy();
		
		pf = new ProxyFactory(beanTwo);
		pf.addAdvisor(advisor);
		proxyTwo = (BeanTwo) pf.getProxy();
		
		proxyOne.foo();
		proxyTwo.foo();
		
		proxyOne.bar();
		proxyTwo.bar();
	}
}
