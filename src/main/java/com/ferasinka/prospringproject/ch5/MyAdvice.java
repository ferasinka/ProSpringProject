package com.ferasinka.prospringproject.ch5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {
	@Pointcut("execution(* com.ferasinka.prospringproject.ch5..foo* (int)) && args(intValue)")
	public void fooExecution(int intValue) {
	}
	
	@Pointcut("bean(myDependency*)")
	public void inMyDependency() {
	}
	
	@Before("fooExecution(intValue) && inMyDependency()")
	public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue) {
		if (intValue != 100) {
			System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName() + " " +
					joinPoint.getSignature().getName() + " argument: " + intValue);
		}
	}
	
	@Around("fooExecution(intValue) && inMyDependency()")
	public Object simpleAroundAdvice(ProceedingJoinPoint joinPoint, int intValue) throws Throwable {
		System.out.println("Before: " + joinPoint.getSignature().getDeclaringTypeName() + " " +
				joinPoint.getSignature().getName() + " argument: " + intValue);
		
		Object retVal = joinPoint.proceed();
		
		System.out.println("After: " + joinPoint.getSignature().getDeclaringTypeName() + " " +
				joinPoint.getSignature().getName() + " argument: " + intValue);
		
		return retVal;
	}
}
