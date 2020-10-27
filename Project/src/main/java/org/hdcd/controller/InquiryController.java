package org.hdcd.controller;

import java.util.ArrayList;
import java.util.List;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.common.domain.PageRequest;
import org.hdcd.common.domain.Pagination;
import org.hdcd.common.security.domain.CustomUser;
import org.hdcd.domain.Inquiry;
import org.hdcd.domain.Member;
import org.hdcd.service.InquiryService;
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
@RequestMapping("/inquiry")
public class InquiryController {
	
	private static final Logger logger = LoggerFactory.getLogger(InquiryController.class);
	
	@Autowired
	private InquiryService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public void registerForm(Model model, Authentication authentication) throws Exception {
		logger.info("Inquiry RegisterForm");
		
		CustomUser customUser = (CustomUser)authentication.getPrincipal();
		Member member = customUser.getMember();
		
		Inquiry inquiry = new Inquiry();
		
		inquiry.setWriter(member.getUserId());
		
		model.addAttribute(inquiry);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public String register(Inquiry inquiry, RedirectAttributes rttr) throws Exception {
		logger.info("Inquiry Register");
		
		service.register(inquiry);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/inquiry/list";
	}
	
	@RequestMapping(value = "/adminregister", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void adminregisterForm(Model model, Authentication authentication) throws Exception {
		logger.info("Inquiry Admin RegisterForm");
		
		CustomUser customUser = (CustomUser)authentication.getPrincipal();
		Member member = customUser.getMember();
		
		Inquiry inquiry = new Inquiry();
		
		inquiry.setWriter(member.getUserId());
				
		model.addAttribute(inquiry);
	}
	
	
	@RequestMapping(value = "/adminregister", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminregister(Inquiry inquiry, RedirectAttributes rttr) throws Exception {
		logger.info("Inquiry Register");
		
		service.adminregister(inquiry);
		
		service.modgroupOrd(inquiry);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/inquiry/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		logger.info("Inquiry List");
		
		model.addAttribute("list", service.list(pageRequest));
		
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		
		pagination.setTotalCount(service.count(pageRequest));
		
		model.addAttribute("pagination", pagination);
		
		List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("n", "---"));
		searchTypeCodeValueList.add(new CodeLabelValue("t", "Title"));
		searchTypeCodeValueList.add(new CodeLabelValue("c", "Content"));
		searchTypeCodeValueList.add(new CodeLabelValue("tc", "Title OR Content"));
		
		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(int inquiryNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		logger.info("Inquiry Read");
		
		Inquiry inquiry = service.read(inquiryNo);
				
		model.addAttribute(inquiry);
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
	public String remove(int inquiryNo, PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		logger.info("Inquiry Remove");
		
		service.remove(inquiryNo);
		
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
		rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/inquiry/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
	public void modifyForm(int inquiryNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		logger.info("Inquiry ModifyForm");
		
		Inquiry inquiry = service.read(inquiryNo);
								
		model.addAttribute(inquiry);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
	public String modify(Inquiry inquiry, PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		logger.info("Inquiry Modify");
		
		service.modify(inquiry);
		
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
		rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());
				
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/inquiry/list";
	}
	
}