package org.hdcd.controller;

import java.util.ArrayList;
import java.util.List;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.common.domain.PageRequest;
import org.hdcd.common.domain.Pagination;
import org.hdcd.domain.Notice;
import org.hdcd.service.NoticeService;
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
@RequestMapping("/notice")
public class NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void registerForm(Model model, Authentication authentication) throws Exception {
		logger.info("Notice RegisterForm");
		
		Notice notice = new Notice();
		
		model.addAttribute(notice);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String register(Notice notice, RedirectAttributes rttr) throws Exception {
		logger.info("Notice Register");
		
		service.register(notice);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/notice/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(@ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		logger.info("Notice List");
		
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
	public void read(int noticeNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		logger.info("Notice Read");
		
		Notice notice = service.read(noticeNo);
				
		model.addAttribute(notice);
		
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String remove(int noticeNo, PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		logger.info("Notice Remove");
		
		service.remove(noticeNo);
		
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
		rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/notice/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void modifyForm(int noticeNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		logger.info("Notice ModifyForm");
		
		Notice notice = service.read(noticeNo);
								
		model.addAttribute(notice);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(Notice notice, PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		logger.info("Notice Modify");
		
		service.modify(notice);
		
		rttr.addAttribute("page", pageRequest.getPage());
		rttr.addAttribute("sizePerPage", pageRequest.getSizePerPage());
		rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());
				
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/notice/list";
	}

}
