package com.ferasinka.prospringproject.ch5;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified {
	private boolean isModified;
	private Map<Method, Method> methodCache = new ConcurrentHashMap<>();
	
	@Override
	public boolean isModified() {
		return isModified;
	}
	
	@Override
	@SuppressWarnings("all")
	public Object invoke(MethodInvocation invocation) throws Throwable {
		if (!isModified) {
			if ((invocation.getMethod().getName().startsWith("set")) && (invocation.getArguments().length == 1)) {
				Method getter = getGetter(invocation.getMethod());
				
				if (getter != null) {
					Object newVal = invocation.getArguments()[0];
					Object oldVal = getter.invoke(invocation.getThis(), null);
					
					if (newVal == null && oldVal == null) {
						isModified = false;
					} else if (newVal == null && oldVal != null) {
						isModified = true;
					} else if (newVal != null && oldVal == null) {
						isModified = true;
					} else {
						isModified = !newVal.equals(oldVal);
					}
				}
			}
		}
		
		return super.invoke(invocation);
	}
	
	private Method getGetter(Method setter) {
		Method getter = null;
		
		getter = methodCache.get(setter);
		
		if (getter != null) {
			return getter;
		}
		
		String getterName = setter.getName().replaceFirst("set", "get");
		
		try {
			getter = setter.getDeclaringClass().getMethod(getterName, null);
			
			methodCache.put(setter, getter);
			
			return getter;
		} catch (NoSuchMethodException e) {
			return null;
		}
	}
}
