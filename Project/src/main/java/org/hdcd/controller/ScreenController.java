package org.hdcd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.domain.Member;
import org.hdcd.domain.Screen;
import org.hdcd.service.ProvinceService;
import org.hdcd.service.ScreenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/screen")
public class ScreenController {
	private static final Logger logger = LoggerFactory.getLogger(ScreenController.class);
	
	@Autowired
	private ScreenService service;
	
	@Autowired
	private ProvinceService provinceService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void registerForm(Model model) throws Exception {
		logger.info("Screen RegisterForm");
		
		Screen screen = new Screen();
		
		model.addAttribute(screen);
		
		List<CodeLabelValue> provinceNameList = provinceService.getProvinceClassList();
		model.addAttribute("provinceNameList", provinceNameList);
		
		String provinceName = "";
		
		List<CodeLabelValue> cityList = provinceService.getProvinceList(provinceName);
		model.addAttribute("cityList", cityList);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String register(Screen screen, RedirectAttributes rttr) throws Exception {
		logger.info("Screen Register");
		
		service.register(screen);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/screen/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void list(Model model) throws Exception {
		logger.info("Screen List");
		
		model.addAttribute("list", service.list());
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void read(int screenNo, Model model) throws Exception {
		logger.info("Screen Read");
		
		Screen screen = service.read(screenNo);
				
		model.addAttribute(screen);
		
		List<CodeLabelValue> provinceNameList = provinceService.getProvinceClassList();
		model.addAttribute("provinceNameList", provinceNameList);
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String remove(int screenNo, RedirectAttributes rttr) throws Exception {
		logger.info("Screen Remove");
		
		service.remove(screenNo);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/screen/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void modifyForm(int screenNo, Model model) throws Exception {
		logger.info("Screen ModifyForm");
		
		Screen screen = service.read(screenNo);
								
		model.addAttribute(screen);
		
		List<CodeLabelValue> provinceNameList = provinceService.getProvinceClassList();
		model.addAttribute("provinceNameList", provinceNameList);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(Screen screen, RedirectAttributes rttr) throws Exception {
		logger.info("ProvinceDetail Modify");
		
		service.modify(screen);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/screen/list";
	}

}
