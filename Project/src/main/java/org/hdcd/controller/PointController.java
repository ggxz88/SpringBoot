package org.hdcd.controller;

import java.util.Locale;

import org.hdcd.common.security.domain.CustomUser;
import org.hdcd.domain.ChargePoint;
import org.hdcd.domain.Member;
import org.hdcd.service.PointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/point")
public class PointController {
	private static final Logger logger = LoggerFactory.getLogger(PointController.class);
	
	@Autowired
	private PointService service;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = "/charge", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public void chargeForm(Model model) throws Exception {
		logger.info("chargeForm");
		
		ChargePoint chargePoint = new ChargePoint();
		chargePoint.setAmount(1000);
		
		model.addAttribute(chargePoint);
	}
	
	@RequestMapping(value = "/charge", method= RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public String charge(int amount, RedirectAttributes rttr, Authentication authentication) throws Exception {
		logger.info("charge");
		
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		Member member = customUser.getMember();
		
		String userId = member.getUserId();
		
		ChargePoint chargePoint = new ChargePoint();
		
		chargePoint.setUserId(userId);
		chargePoint.setAmount(amount);
		
		service.charge(chargePoint);
		
		String message = messageSource.getMessage("point.chargingComplete", null, Locale.KOREAN);
		rttr.addFlashAttribute("msg", message);
		
		return "redirect:/point/success";
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public void list(Model model, Authentication authentication) throws Exception {
		logger.info("list");
		
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		Member member = customUser.getMember();
		
		String userId = member.getUserId();
		
		model.addAttribute("list", service.list(userId));
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String success() throws Exception {
		return "point/success";
	}
}
