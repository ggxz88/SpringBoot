package org.hdcd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.common.security.domain.CustomUser;
import org.hdcd.domain.Member;
import org.hdcd.domain.Reservation;
import org.hdcd.domain.Seat;
import org.hdcd.service.MemberService;
import org.hdcd.service.ProvinceService;
import org.hdcd.service.ReservationService;
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
@RequestMapping("/reserve")
public class ReservationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private ReservationService service;
	
	@Autowired 
	private MemberService memberService;
	
	@Autowired
	private ProvinceService provinceService;
	
	@Autowired
	private TimeService timeService;
	
	
	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public void reserveForm(Model model) throws Exception {
		logger.info("reserveForm");
		
		Reservation reservation = new Reservation();
		
		model.addAttribute(reservation);
		
		List<CodeLabelValue> movieList = timeService.movieList();
		
		model.addAttribute("movieList", movieList);
		
	}
	
	@RequestMapping(value = "/resProvince", method = RequestMethod.GET)
	public void resProvince(Model model, HttpServletRequest req) throws Exception {
		logger.info("resProvince");
		
		Reservation reservation = new Reservation();
		
		model.addAttribute(reservation);
		
		String title = req.getParameter("title");
		
		reservation.setTitle(title);
		
		List<CodeLabelValue> provinceNameList = provinceService.getProvinceClassList();
		
		model.addAttribute("provinceNameList", provinceNameList);
		
	}
	
	@RequestMapping(value = "/resTheater", method = RequestMethod.GET)
	public void resTheater(Model model, HttpServletRequest req) throws Exception {
		logger.info("resTheater");
		
		Reservation reservation = new Reservation();
		
		model.addAttribute(reservation);
		
		String provinceName = req.getParameter("provinceName");
		
		String title = req.getParameter("title");
				
		List<CodeLabelValue> cityList = provinceService.getcityList(provinceName, title);
		
		model.addAttribute("cityList", cityList);
		
	}
	
	@RequestMapping(value = "/resTime", method = RequestMethod.GET)
	public void resTime(Model model, HttpServletRequest req) throws Exception {
		logger.info("resTime");
		
		Reservation reservation = new Reservation();
		
		model.addAttribute(reservation);
		
		String city = req.getParameter("city");
		
		String title = req.getParameter("title");
		
		List<CodeLabelValue> dayList = provinceService.getdayList(city, title);
		
		model.addAttribute("dayList", dayList);
		
	}
	
	@RequestMapping(value = "/resSeat", method = RequestMethod.GET)
	public void resSeat(Model model, HttpServletRequest req) throws Exception {
		logger.info("resSeat");
		
		Reservation reservation = new Reservation();
		
		model.addAttribute(reservation);
		
		String showTime = req.getParameter("showTime");
		
		List<Seat> seatList = service.getSeatList(showTime);
		
		model.addAttribute("seatList", seatList);
		
	}
	
	@RequestMapping(value = "/reserve", method= RequestMethod.POST)
	public String reserve(Reservation reservation, RedirectAttributes rttr, Authentication authentication) throws Exception {
		logger.info("reserve");
		
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		Member member = customUser.getMember();
		
		String userId = member.getUserId();
		
		member.setPoint(memberService.getPoint(userId));
		
		service.register(member, reservation);
		
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
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
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
