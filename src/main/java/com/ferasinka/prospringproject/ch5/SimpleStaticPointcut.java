package com.ferasinka.prospringproject.ch5;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return "foo".equals(method.getName());
	}
	
	@Override
	public ClassFilter getClassFilter() {
		return clazz -> clazz == BeanOne.class;
	}
}
