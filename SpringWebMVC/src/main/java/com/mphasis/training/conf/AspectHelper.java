package com.mphasis.training.conf;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectHelper {
	@Pointcut("execution(* com.mphasis.training.daos.*.*(..))")
	public void getAll() {}
	
	@Before("getAll()")
	public void beforeMethod(JoinPoint joinPoint ) {
		System.out.println("before the method"
	+joinPoint.getSignature().getName());
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}
	
	@After("getAll()")
	public void afterMethod(JoinPoint joinPoint ) {
		System.out.println("after the method"
	+joinPoint.getSignature().getName());
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}
	
	@AfterThrowing(pointcut =
			"execution(* com.mphasis.training.daos.*.*(..))",
			throwing = "ex")
	public void afterThrowingExecution(JoinPoint jp, Exception ex) {
		System.out.println("After throwing advice: "
				+ jp.getSignature().getName() + ". Class: "
				+ jp.getTarget().getClass().getSimpleName());
		System.out.println("Exception: " + ex.getMessage());
	}
	
	@Around("getAll()")
	public void aroundMethod(JoinPoint joinPoint ) {
		System.out.println("around the method"
	+joinPoint.getSignature().getName());
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}
	
	
	@AfterReturning("getAll()")
	public void afterReturnMethod(JoinPoint joinPoint ) {
		System.out.println("after returning the method"
	+joinPoint.getSignature().getName());
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}

}
