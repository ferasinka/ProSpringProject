package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnotationPointcutExample {
	public static void main(String[] args) {
		SampleAnnotationBean target = new SampleAnnotationBean();
		
		AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());
		ProxyFactory factory = new ProxyFactory(target);
		
		factory.addAdvisor(advisor);
		
		SampleAnnotationBean proxy = (SampleAnnotationBean) factory.getProxy();
		
		proxy.foo(100);
		proxy.bar();
	}
}
