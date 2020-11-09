package org.hdcd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.domain.Screen;
import org.hdcd.domain.Seat;
import org.hdcd.service.ProvinceService;
import org.hdcd.service.ScreenService;
import org.hdcd.service.SeatService;
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
@RequestMapping("/screen")
public class ScreenController {
	private static final Logger logger = LoggerFactory.getLogger(ScreenController.class);
	
	@Autowired
	private ScreenService service;
	
	@Autowired
	private SeatService seatService;
	
	
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
		
	}
	
	@RequestMapping(value = "/regTheater", method = RequestMethod.GET)
	public void regTheater(Model model, HttpServletRequest req) throws Exception {
		logger.info("Screen regTheater");
		
		Screen screen = new Screen();
		
		model.addAttribute(screen);
		
		String provinceName = req.getParameter("provinceName");
				
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
	public void read(String city, String screenName, Model model) throws Exception {
		logger.info("Screen Read");
		
		Screen screen = service.read(city, screenName);
				
		model.addAttribute(screen);
		
		List<Seat> seatList = seatService.list(city, screenName);
		
		model.addAttribute("list", seatList);
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String remove(String city, String screenName, RedirectAttributes rttr) throws Exception {
		logger.info("Screen Remove");
		
		service.remove(city, screenName);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/screen/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void modifyForm(String city, String screenName, Model model) throws Exception {
		logger.info("Screen ModifyForm");
		
		Screen screen = service.read(city, screenName);
								
		model.addAttribute(screen);
		
		List<CodeLabelValue> provinceNameList = provinceService.getProvinceClassList();
		model.addAttribute("provinceNameList", provinceNameList);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(Screen screen, RedirectAttributes rttr) throws Exception {
		logger.info("Screen Modify");
		
		service.modify(screen);
				
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/screen/list";
	}
	
}
