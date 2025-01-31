package com.demo.spring_data_rest_h2_demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
	// Defines a pointcut that matches the execution of any public method in classes
	// under com.example.service package
	@Pointcut("execution(public void com.demo.spring_data_rest_h2_demo.*.*(..))")
	public void allServiceMethods() {}

	@Before("allServiceMethods()")
	// Advice that runs before the execution of methods matched by the pointcut
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before method: " + joinPoint.getSignature().getName());
	}

	@After("allServiceMethods()")
	// Advice that runs after the execution of methods matched by the pointcut,
	// regardless of their outcome
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("After method: " + joinPoint.getSignature().getName());
	}

	@AfterReturning(pointcut = "allServiceMethods()", returning = "result")
	// Advice that runs after a method matched by the pointcut returns successfully
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out.println("Method returned: " + result);
	}

	@AfterThrowing(pointcut = "allServiceMethods()", throwing = "error")
	// Advice that runs if a method matched by the pointcut throws an exception
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("Method threw exception: " + error);
	}

	@Around("allServiceMethods()")
	// Advice that runs before and after the execution of methods matched by the
	// pointcut
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Before and after method: " + joinPoint.getSignature().getName());
		return joinPoint.proceed(); // Proceed with the next advice or target method invocation
	}
}
