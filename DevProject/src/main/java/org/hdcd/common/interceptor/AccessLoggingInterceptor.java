package org.hdcd.common.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AccessLoggingInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(AccessLoggingInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("preHandle");
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("postHandle");
		
		//여러 개의 인터셉터 지정
		/*
		String requestURL = request.getRequestURI();
		
		logger.info("requestURL : " + requestURL);
		
		HandlerMethod handlermethod = (HandlerMethod) handler;
		Method method = handlermethod.getMethod();
		
		Class class = method.getDeclaringClass();
		
		String className = class.getName();
		String classSimpleName = class.getSimpleName();
		String methodName = method.getName();
		
		logger.info("[ACCESS CONTREOLLER] " + className + "." + methodName);
		*/
		
		HandlerMethod handlermethod = (HandlerMethod) handler;
		Method method = handlermethod.getMethod();
		
		logger.info("[SUCCESS CONTROLLER]{}.{}", method.getDeclaringClass().getSimpleName(), method.getName());
	}
}
