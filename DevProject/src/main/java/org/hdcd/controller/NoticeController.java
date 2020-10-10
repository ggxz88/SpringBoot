package org.hdcd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;

public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	//18. 스프링 시큐리티
	//스프링 시큐리티 설정
		
	@RequestMapping("/list")
	public void list() {
		logger.info("list : access to all");
	}
	
	//관리자 권한을 가진 사용자만 접근이 가능하다.
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/register")
	public void registerForm() {
		logger.info("reigsterForm : access to admin");
	}
}
