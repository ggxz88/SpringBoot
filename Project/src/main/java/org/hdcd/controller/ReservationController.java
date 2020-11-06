package org.hdcd.controller;

import org.hdcd.common.security.domain.CustomUser;
import org.hdcd.domain.Member;
import org.hdcd.domain.Reservation;
import org.hdcd.service.MemberService;
import org.hdcd.service.ReservationService;
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
@RequestMapping("/reserve")
public class ReservationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private ReservationService service;
	
	@Autowired 
	private MemberService memberService;
	
	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public void reserveForm(Model model) throws Exception {
		logger.info("reserveForm");
		
		Reservation reservation = new Reservation();
		
		model.addAttribute(reservation);
		
		
	}
	
	@RequestMapping(value = "/reserve", method= RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public String reserve(int amount, RedirectAttributes rttr, Authentication authentication) throws Exception {
		logger.info("reserve");
		
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		Member member = customUser.getMember();
		
		String userId = member.getUserId();
		
		member.setPoint(memberService.getPoint(userId));
		
		service.register(member);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/reserve/success";
		
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String success() throws Exception {
		logger.info("Reserve Success");
		
		return "reserve/success";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public void listAll(Model model) throws Exception {
		logger.info("My Reservation listAll");
		
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public void list(Model model, Authentication authentication) throws Exception {
		logger.info("My Reservation list");
		
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		Member member = customUser.getMember();
		
		String userId = member.getUserId();
		
		model.addAttribute("list", service.list(userId));
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public void read(int movieReserveNo, Model model) throws Exception {
		logger.info("My Reservation read");
		
		model.addAttribute(service.read(movieReserveNo));
	}

}
