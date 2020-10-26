package org.hdcd.common.exception;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hdcd.exception.NotEnoughPointException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CommonExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	
	@ExceptionHandler(NotEnoughPointException.class)
	public String handleNotEnoughPointException(NotEnoughPointException ex, WebRequest request) {
		logger.info("handleNotEnoughPointException");
		
		return "redirect:/point/notEnoughPoint";
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public void handleAccessDeniedException(AccessDeniedException ex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(isAjax(request)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		else {
			throw ex;
		}
	}
	
	@ExceptionHandler(Exception.class)
	public String handle(Exception ex) {
		logger.info("handle ex " + ex.toString());
		
		return "error/errorCommon";
	}
	
	public static boolean isAjax(HttpServletRequest request) {
		return "XMLHttpREquest".equals(request.getHeader("X-Requestd-With"));
	}

}
