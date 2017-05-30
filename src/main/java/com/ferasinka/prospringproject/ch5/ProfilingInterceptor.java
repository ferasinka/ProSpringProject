package com.ferasinka.prospringproject.ch5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		StopWatch watch = new StopWatch();
		
		watch.start(invocation.getMethod().getName());
		
		Object returnValue = invocation.proceed();
		
		watch.stop();
		
		dumpInfo(invocation, watch.getTotalTimeMillis());
		
		return returnValue;
	}
	
	private void dumpInfo(MethodInvocation invocation, long ms) {
		Method m = invocation.getMethod();
		
		Object target = invocation.getThis();
		Object[] args = invocation.getArguments();
		
		System.out.println("Executed method: " + m.getName());
		System.out.println("On object of type: " + target.getClass().getName());
		System.out.println("With arguments: ");
		
		for (Object arg : args) {
			System.out.print("\t> " + arg);
		}
		
		System.out.println();
		System.out.println("Took: " + ms + "ms");
	}
}
