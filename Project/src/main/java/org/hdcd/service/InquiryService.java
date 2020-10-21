package org.hdcd.service;

import java.util.List;

import org.hdcd.common.domain.PageRequest;
import org.hdcd.domain.Inquiry;

public interface InquiryService {
	
	public void register(Inquiry inquiry) throws Exception;
	
	public void adminregister(Inquiry inquiry) throws Exception;
	
	public Inquiry read(Integer inquiryNo) throws Exception;
	
	public void modify(Inquiry inquiry) throws Exception;
	
	public void remove(Integer inquiryNo) throws Exception;
	
	public List<Inquiry> list(PageRequest pageRequest) throws Exception;

	public int count(PageRequest pageRequest) throws Exception;
}
