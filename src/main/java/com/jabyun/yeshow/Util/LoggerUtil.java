package com.jabyun.yeshow.Util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerUtil {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public LoggerUtil() {}

	@AfterReturning("execution(* com.jabyun.yeshow.Service.*.*(..))")
	public void logMethodAccessAfter(JoinPoint joinPoint) {
		
		logger.debug("[class]:" + joinPoint.getTarget().getClass().getName());
		logger.debug("[method]:" + joinPoint.getSignature().getName() + "()");
		logger.debug(">>>>>>>>>> LOGGING END >>>>>>>>>>");
		logger.debug("=================================================");
	}
	
	@Before("execution(* com.jabyun.yeshow.Service.*.*(..))")
	public void logMethodAccessBefore(JoinPoint joinPoint) {
		
		Object thisObj = joinPoint.getTarget();
		String className = thisObj.getClass().getName();
		Object[] args = joinPoint.getArgs();
		logger.debug("=================================================");
		logger.debug(">>>>>>>>> LOGGING START >>>>>>>>>>");
		logger.debug("[class]:" + className);
		logger.debug("[method]:" + joinPoint.getSignature().getName() + "()");

	}
}
