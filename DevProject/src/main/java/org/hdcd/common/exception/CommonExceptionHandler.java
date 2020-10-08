package org.hdcd.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	
	//16. 예외 처리
	//예외 처리 애너테이션
	/*
	@ExceptionHandler(Exception.class)
	public String handle(Exception e) {
		
		logger.info(e.toString());
		
		return "error/errorCommon";
	}
	*/
	
	//예외 정보 출력
	
	@ExceptionHandler(Exception.class)
	public String handle(Exception ex, Model model) {
		logger.info("handle " + ex.toString());
		
		model.addAttribute("exception", ex);
		
		return "error/errorCommon";
	}
}
