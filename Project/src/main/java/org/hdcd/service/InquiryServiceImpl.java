package org.hdcd.service;

import java.util.List;

import org.hdcd.common.domain.PageRequest;
import org.hdcd.domain.Inquiry;
import org.hdcd.mapper.InquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InquiryServiceImpl implements InquiryService {

	@Autowired
	private InquiryMapper mapper;
	
	@Override
	public void register(Inquiry inquiry) throws Exception {
		mapper.create(inquiry);
	}
	
	@Override
	public void adminregister(Inquiry inquiry) throws Exception {
		mapper.admincreate(inquiry);		
	}
	
	@Override
	public void modgroupOrd(Inquiry inquiry) throws Exception {
		mapper.updgroupOrd(inquiry);
	}
	
	
	@Override
	public Inquiry read(Integer inquiryNo) throws Exception {
		return mapper.read(inquiryNo);
	}
	
	@Override
	public void modify(Inquiry inquiry) throws Exception {
		mapper.update(inquiry);
	}
	
	@Override
	public void remove(Integer inquiryNo) throws Exception {
		mapper.delete(inquiryNo);
	}
	
	@Override
	public List<Inquiry> list(PageRequest pageRequest) throws Exception {
		return mapper.list(pageRequest);
	}

	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return mapper.count(pageRequest);
	}
	
}
