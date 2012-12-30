package com.bjsxt.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
	@Pointcut(
		"execution(public * com.bjsxt.service..*.add(..)) || " +
		"execution(public * com.bjsxt.service..*.delete(..))"
	)
	public void myMethod(){};
	
	@Around("myMethod()")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("method around start");
		Object object = null;
		final int times = 3;
		int i = 0;
		for (i = 0; i < times; ++i) {
			try {
				object = pjp.proceed();
				break;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		System.out.println("method around end, i==" +i);
		return object;
	}
	
}
