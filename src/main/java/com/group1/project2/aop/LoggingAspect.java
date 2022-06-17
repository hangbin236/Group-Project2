package com.group1.project2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
	final static Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.group1.project2..*(..)))")
	public void beforeLogging(JoinPoint joinPoint) {
		
		String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
		String methodName = joinPoint.getSignature().getDeclaringType().getName();
		LOG.info("Entering " + className + "." + methodName + "()");
	}
	
	@After("execution(* com.group1.project2..*(..)))")
	public void afterLogging(JoinPoint joinPoint) {
		
		String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
		String methodName = joinPoint.getSignature().getDeclaringType().getName();
		LOG.info("Exiting " + className + "." + methodName + "()");
	}
}