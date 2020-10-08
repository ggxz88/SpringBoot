package org.hdcd.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceLoggerAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceLoggerAdvice.class);
	
	//14. AOP
	
	//Before 어드바이스
	//org.hdcd.service.BoardService 클래스에 속한 임의의 메소드를 대상으로 한다.
	@Before("execution(*	org.hdcd.service.BoardService*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("startLog");
		
		logger.info("startLog : " + jp.getSignature());
		logger.info("startLog : " + Arrays.toString(jp.getArgs()));
	}
	
	//After Returning 어드바이스
	//org.hdcd.service.BoardService 클래스에 속한 임의의 메소드를 대상으로 한다.
	@AfterReturning("execution(*	org.hdcd.service.BoardService*.*(..))")
	public void logReturning(JoinPoint jp) {
		logger.info("logReturning");
		logger.info("logReturning : " + jp.getSignature());
	}
	
	//After Throwing 어드바이스
	//org.hdcd.service.BoardService 클래스에 속한 임의의 메소드를 대상으로 한다.
	@AfterThrowing(pointcut = "execution(*	org.hdcd.service.BoardService*.*(..))", throwing = "e")
	public void logException(JoinPoint jp, Exception e) {
		logger.info("logException");
		logger.info("logException : " + jp.getSignature());
		
		logger.info("logException : " + e);
	}
	
	//After 어드바이스
	//org.hdcd.service.BoardService 클래스에 속한 임의의 메소드를 대상으로 한다.
	@After("execution(*	org.hdcd.service.BoardService*.*(..))")
	public void endLog(JoinPoint jp) {
		logger.info("endLog");
		logger.info("endLog : " + jp.getSignature());
		logger.info("endLog : " + Arrays.toString(jp.getArgs()));
	}
	
	
}
