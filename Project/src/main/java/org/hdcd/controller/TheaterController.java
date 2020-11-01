package org.hdcd.controller;

import org.hdcd.domain.Theater;
import org.hdcd.service.TheaterService;
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
@RequestMapping("/theater")
public class TheaterController {

	private static final Logger logger = LoggerFactory.getLogger(BannerController.class);
	
	@Autowired
	private TheaterService theaterService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void registerForm(Model model) throws Exception {
		logger.info("Theater RegisterForm");
		
		Theater theater = new Theater();
		
		model.addAttribute(theater);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String register(Theater theater, RedirectAttributes rttr) throws Exception {
		logger.info("Theater Register");
		
		theaterService.register(theater);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/theater/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void list(Model model) throws Exception {
		logger.info("Theater List");
		
		model.addAttribute("list", theaterService.list());
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void read(int theaterNo, Model model) throws Exception {
		logger.info("Theater Read");
		
		Theater theater = theaterService.read(theaterNo);
				
		model.addAttribute(theater);
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String remove(int theaterNo, RedirectAttributes rttr) throws Exception {
		logger.info("Theater Remove");
		
		theaterService.remove(theaterNo);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/theater/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void modifyForm(int theaterNo, Model model) throws Exception {
		logger.info("Theater ModifyForm");
		
		Theater theater = theaterService.read(theaterNo);
								
		model.addAttribute(theater);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(Theater theater, RedirectAttributes rttr) throws Exception {
		logger.info("Theater Modify");
		
		theaterService.modify(theater);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/theater/list";
	}
	
}
