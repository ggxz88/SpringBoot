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

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	//인터셉터 활용 - 세션 처리
	private static final String USER_INFO = "userInfo";
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("preHandle");
		
		//인터셉터 활용 - 세션 처리
		//여러 개의 인터셉터 지정
		
		String requestURL = request.getRequestURI();
		
		logger.info("requestURL : " + requestURL);
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		logger.info("Bean : " + method.getBean());
		logger.info("Method : " + methodObj);
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute(USER_INFO) != null) {
			session.removeAttribute(USER_INFO);
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("postHandle");
		
		//인터셉터 활용 - 세션 처리
		//여러 개의 인터셉터 지정
		
		String requestURL = request.getRequestURI();
		
		logger.info("requestURL : " + requestURL);
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		logger.info("Bean : " + method.getBean());
		logger.info("Method : " + methodObj);
		
		HttpSession session = request.getSession();
		
		ModelMap modelMap = modelAndView.getModelMap();
		Object member = modelMap.get("user");
		
		if(member != null) {
			logger.info("member != null");
			
			session.setAttribute(USER_INFO, member);
			
			response.sendRedirect("/");
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("afterCompletion");
		
		//인터셉터 활용 - 세션 처리
		//여러 개의 인터셉터 지정
		
		String requestURL = request.getRequestURI();
		
		logger.info("requestURL : " + requestURL);
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		logger.info("Bean : " + method.getBean());
		logger.info("Method : " + methodObj);
		
	}

}
