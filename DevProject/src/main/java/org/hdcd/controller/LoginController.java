package org.hdcd.controller;

import org.hdcd.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("loginForm");
		
		return "loginForm";
	}
	
	//인터셉터 설정
	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Member member, Model model) {
		logger.info("login");
		
		logger.info("login userId = " + member.getUserId());
		logger.info("login userPw = " + member.getUserPw());
		
		model.addAttribute("result", "로그인 되었습니다.");
		
		return "success";
	}
	*/
	
	//인터셉터 활용 - 세션 처리
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(String userId, String userPw, Model model) {
		logger.info("login");
		
		logger.info("login userId = " + userId);
		logger.info("login userPw = " + userPw);
		
		Member member = new Member();
		
		member.setUserId(userId);
		member.setUserPw(userPw);
		member.setUserName("홍길동");
		member.setEmail("hkd@aaa.com");
		
		model.addAttribute("user", member);
		
	}
}
