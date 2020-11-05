package org.hdcd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.domain.Time;
import org.hdcd.service.ProvinceService;
import org.hdcd.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/time")
public class TimeController {
	
	private static final Logger logger = LoggerFactory.getLogger(TimeController.class);
	
	@Autowired
	private TimeService service;
	
	@Autowired
	private ProvinceService provinceService;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void registerForm(Model model, Authentication authentication) throws Exception {
		logger.info("Time RegisterForm");
		
		Time time = new Time();
		
		model.addAttribute(time);
		
		List<CodeLabelValue> provinceNameList = provinceService.getProvinceClassList();
		
		model.addAttribute("provinceNameList", provinceNameList);
		
	}
	
	@RequestMapping(value = "/regTheater", method = RequestMethod.GET)
	public void regTheater(Model model, HttpServletRequest req) throws Exception {
		logger.info("Time regTime");
		
		Time time = new Time();
		
		model.addAttribute(time);
		
		String provinceName = req.getParameter("provinceName");
				
		List<CodeLabelValue> cityList = provinceService.getProvinceList(provinceName);
		
		model.addAttribute("cityList", cityList);
		
	}
	
	@RequestMapping(value = "/regTime", method = RequestMethod.GET)
	public void regTime(Model model, HttpServletRequest req) throws Exception {
		logger.info("Time regTime");
		
		Time time = new Time();
		
		model.addAttribute(time);
		
		String city = req.getParameter("city");
		
		List<CodeLabelValue> screenList = service.screenList(city);
		
		model.addAttribute("screenList", screenList);
		
		List<CodeLabelValue> movieList = service.movieList();
		
		model.addAttribute("movieList", movieList);
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String register(Time time, RedirectAttributes rttr) throws Exception {
		logger.info("Time Register");
		
		service.register(time);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/time/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void list(Model model) throws Exception {
		logger.info("Time List");
		
		model.addAttribute("list", service.list());
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void read(int timeNo, Model model) throws Exception {
		logger.info("Time Read");
		
		Time time = service.read(timeNo);
				
		model.addAttribute(time);
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String remove(int timeNo, RedirectAttributes rttr) throws Exception {
		logger.info("Time Remove");
		
		service.remove(timeNo);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/time/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void modifyForm(int timeNo, Model model) throws Exception {
		logger.info("Time ModifyForm");
		
		Time time = service.read(timeNo);
								
		model.addAttribute(time);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(Time time, RedirectAttributes rttr) throws Exception {
		logger.info("Time Modify");
		
		service.modify(time);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/time/list";
	}
	
}