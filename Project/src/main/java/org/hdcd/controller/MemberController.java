package org.hdcd.controller;

import org.hdcd.domain.Member;
import org.hdcd.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerForm(Member member, Model model) throws Exception {
		logger.info("registerForm");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Validated Member member, BindingResult result, Model model, RedirectAttributes rttr) throws Exception {
		String inputPassword = member.getUserPw();
		member.setUserPw(passwordEncoder.encode(inputPassword));
		
		service.register(member);
		
		rttr.addFlashAttribute("userName", member.getUserName());
		
		return "redirect:/user/registerSuccess";
	}
	
	@RequestMapping(value = "/registerSuccess", method = RequestMethod.GET)
	public void registerSuccess(Model model) throws Exception {
		logger.info("registerSuccess");
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		model.addAttribute("list", service.list());
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(String userId, Model model) throws Exception {
		model.addAttribute(service.read(userId));
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(String userId, RedirectAttributes rttr) throws Exception {
		service.remove(userId);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/user/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(String userId, Model model) throws Exception {
		model.addAttribute(service.read(userId));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Member member, RedirectAttributes rttr) throws Exception {
		service.modify(member);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/user/list";
	}
}
