package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class IntroductionExample {
	public static void main(String[] args) {
		TargetBean target = new TargetBean();
		target.setName("Andrey Kuznetsov");
		
		IntroductionAdvisor advisor = new IsModifiedAdvisor();
		ProxyFactory factory = new ProxyFactory();
		
		factory.setTarget(target);
		factory.addAdvisor(advisor);
		factory.setOptimize(true);
		
		TargetBean proxy = (TargetBean) factory.getProxy();
		IsModified proxyInterface = (IsModified) proxy;
		
		System.out.println("Is TargetBean?: " + (proxy instanceof TargetBean));
		System.out.println("Is IsModified?: " + (proxy instanceof IsModified));
		
		System.out.println("Has been modified?: " + proxyInterface.isModified());
		
		proxy.setName("Andrey Kuznetsov");
		
		System.out.println("Has been modified?: " + proxyInterface.isModified());
		
		proxy.setName("Ivan Ivanov");
		
		System.out.println("Has been modified?: " + proxyInterface.isModified());
	}
}
