package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectjExpPointcutExample {
	public static void main(String[] args) {
		AspectjExpBean target = new AspectjExpBean();
		
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* foo*(int))");
		
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());
		
		ProxyFactory factory = new ProxyFactory(target);
		factory.addAdvisor(advisor);
		
		AspectjExpBean proxy = (AspectjExpBean) factory.getProxy();
		
		proxy.foo1();
		proxy.foo2(1);
		proxy.bar();
	}
}
