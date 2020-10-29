package org.hdcd.controller;

import javax.servlet.http.HttpServletRequest;

import org.hdcd.domain.Member;
import org.hdcd.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		logger.info("register");
		
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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void list(Model model) throws Exception {
		logger.info("list");
		
		model.addAttribute("list", service.list());
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(String userId, Model model) throws Exception {
		logger.info("read");
		
		model.addAttribute(service.read(userId));
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String remove(String userId, RedirectAttributes rttr) throws Exception {
		logger.info("remove");
		
		service.remove(userId);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/user/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void modifyForm(String userId, Model model) throws Exception {
		logger.info("modifyForm");
		
		model.addAttribute(service.read(userId));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(Member member, RedirectAttributes rttr) throws Exception {
		logger.info("modify");
		
		service.modify(member);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/user/list";
	}
	
	@RequestMapping(value = "setup", method = RequestMethod.GET)
	public String setupAdminForm(Member member, Model model) throws Exception {
		logger.info("setupAdminForm");
		
		if(service.countAll() == 0) {
			return "user/setup";
		}
		
		return "user/setupFailure";
	}
	
	@RequestMapping(value = "setup", method = RequestMethod.POST)
	public String setupAdmin(Member member, RedirectAttributes rttr) throws Exception {
		logger.info("setupAdmin");
		
		if(service.countAll() == 0) {
			String inputPassword = member.getUserPw();
			member.setUserPw(passwordEncoder.encode(inputPassword));
			
			service.setupAdmin(member);
			
			rttr.addFlashAttribute("userName", member.getUserName());
			
			return "redirect:/user/registerSuccess";
		}
		
		return "redirect:/user/setupFailure";
	}
	
	@ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.POST)
	public int idChk(HttpServletRequest req) throws Exception {
		logger.info("idChk");
		
		String userId = req.getParameter("userId");
		logger.info(userId);
		
		Member idChk = service.idChk(userId);
		
		int result = 0;
		
		if(idChk != null) {
			result = 1;
		}
		
		return result;
	}
	
}