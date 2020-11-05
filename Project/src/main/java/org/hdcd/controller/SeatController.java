package org.hdcd.controller;

import java.util.List;

import org.hdcd.domain.Seat;
import org.hdcd.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/seat")
public class SeatController {
	private static final Logger logger = LoggerFactory.getLogger(SeatController.class);
	
	@Autowired
	private SeatService seatService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String list(@RequestParam String screenName, Model model) throws Exception {
		logger.info("Seat list");
		
		List<Seat> seatList = seatService.list(screenName);
		
		model.addAttribute("list", seatList);
		
		return "seat/list";
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void read(int seatNo, Model model) throws Exception {
		logger.info("Seat Read");
		
		Seat seat = seatService.read(seatNo);
				
		model.addAttribute(seat);
		
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void modifyForm(@RequestParam Integer seatNo, Model model) throws Exception {
		logger.info("Seat ModifyForm");
		
		Seat seat = seatService.read(seatNo);
				
		model.addAttribute(seat);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void modify(Seat seat, @RequestParam Integer seatNo, RedirectAttributes rttr) throws Exception {
		logger.info("seat Modify");
		
		seatService.modify(seat);
				
		rttr.addFlashAttribute("msg", "SUCCESS");
				
	}
	
}
