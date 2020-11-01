package org.hdcd.controller;

import java.util.List;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.domain.ProvinceDetail;
import org.hdcd.service.ProvinceDetailService;
import org.hdcd.service.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/city")
public class ProvinceDetailController {
	private static final Logger logger = LoggerFactory.getLogger(ProvinceDetailController.class);
	
	@Autowired
	private ProvinceDetailService service;
	
	@Autowired
	private ProvinceService provinceService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void registerForm(Model model) throws Exception {
		logger.info("ProvinceDetail RegisterForm");
		
		ProvinceDetail provinceDetail = new ProvinceDetail();
		
		model.addAttribute(provinceDetail);
		
		List<CodeLabelValue> provinceNameList = provinceService.getProvinceClassList();
		model.addAttribute("provinceNameList", provinceNameList);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String register(ProvinceDetail provinceDetail, RedirectAttributes rttr) throws Exception {
		logger.info("ProvinceDetail Register");
		
		service.register(provinceDetail);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/city/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void list(Model model) throws Exception {
		logger.info("ProvinceDetail List");
		
		model.addAttribute("list", service.list());
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void read(int cityNo, Model model) throws Exception {
		logger.info("ProvinceDetail Read");
		
		ProvinceDetail provinceDetail = service.read(cityNo);
				
		model.addAttribute(provinceDetail);
		
		List<CodeLabelValue> provinceNameList = provinceService.getProvinceClassList();
		model.addAttribute("provinceNameList", provinceNameList);
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String remove(int cityNo, RedirectAttributes rttr) throws Exception {
		logger.info("ProvinceDetail Remove");
		
		service.remove(cityNo);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/city/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void modifyForm(int cityNo, Model model) throws Exception {
		logger.info("ProvinceDetail ModifyForm");
		
		ProvinceDetail provinceDetail = service.read(cityNo);
								
		model.addAttribute(provinceDetail);
		
		List<CodeLabelValue> provinceNameList = provinceService.getProvinceClassList();
		model.addAttribute("provinceNameList", provinceNameList);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(ProvinceDetail provinceDetail, RedirectAttributes rttr) throws Exception {
		logger.info("ProvinceDetail Modify");
		
		service.modify(provinceDetail);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/city/list";
	}

}
