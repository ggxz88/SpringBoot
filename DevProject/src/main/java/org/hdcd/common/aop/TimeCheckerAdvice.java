package org.hdcd.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeCheckerAdvice {
private static final Logger logger = LoggerFactory.getLogger(TimeCheckerAdvice.class);
	
	//14. AOP
	
	//Around 어드바이스
	//org.hdcd.service.BoardService 클래스에 속한 임의의 메소드를 대상으로 한다.
	@Around("execution(*	org.hdcd.service.BoardService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		logger.info(Arrays.toString(pjp.getArgs()));
		
		Object result = pjp.proceed();
		long endTime = System.currentTimeMillis();
		logger.info(pjp.getSignature().getName() +  " : " + (endTime - startTime));
		
		return result;
	}
	
	//메서드 정보 획득
	@Before("execution(*	org.hdcd.service.BoardService*.*(..))")
	public void log(JoinPoint jp) {
		
		//프락시가 입혀지기 전의 원본 대상 객체를 가져온다.
		Object targetObject = jp.getTarget();
		
		logger.info("targetObject = " + targetObject);
		
		//프락시를 가져온다.
		Object thisObject = jp.getThis();
		
		logger.info("thisObject = " + thisObject);
		
		//인수를 가져온다.
		Object[] args = jp.getArgs();
		
		logger.info("args.length = " + args.length);
	}
}
