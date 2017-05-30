package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class ProfilingExample {
	public static void main(String[] args) {
		WorkerBean target = new WorkerBean();
		ProxyFactory factory = new ProxyFactory(target);
		
		factory.addAdvice(new ProfilingInterceptor());
		
		WorkerBean proxy = (WorkerBean) factory.getProxy();
		
		proxy.doSomeWork(10_000_000);
	}
}
