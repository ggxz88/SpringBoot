package org.hdcd.controller;

import java.util.ArrayList;
import java.util.List;

import org.hdcd.domain.ProvinceClass;
import org.hdcd.service.ProvinceClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/province")
public class ProvinceClassController {
	private static final Logger logger = LoggerFactory.getLogger(ProvinceClassController.class);
	
	@Autowired
	private ProvinceClassService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void registerForm(Model model) throws Exception {
		logger.info("ProvinceClass RegisterForm");
		
		ProvinceClass provinceClass = new ProvinceClass();
		
		model.addAttribute(provinceClass);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String register(ProvinceClass provinceClass, RedirectAttributes rttr) throws Exception {
		logger.info("ProvinceClass Register");
		
		service.register(provinceClass);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/province/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("ProvinceClass List");
		
		model.addAttribute("list", service.list());
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(int provinceNo, Model model) throws Exception {
		logger.info("ProvinceClass Read");
		
		ProvinceClass provinceClass = service.read(provinceNo);
				
		model.addAttribute(provinceClass);
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String remove(int provinceNo, RedirectAttributes rttr) throws Exception {
		logger.info("ProvinceClass Remove");
		
		service.remove(provinceNo);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/province/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void modifyForm(int provinceNo, Model model) throws Exception {
		logger.info("ProvinceClass ModifyForm");
		
		ProvinceClass provinceClass = service.read(provinceNo);
								
		model.addAttribute(provinceClass);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(ProvinceClass provinceClass, RedirectAttributes rttr) throws Exception {
		logger.info("ProvinceClass Modify");
		
		service.modify(provinceClass);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/province/list";
	}

}
