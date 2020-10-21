package org.hdcd.mapper;

import java.util.List;

import org.hdcd.common.domain.PageRequest;
import org.hdcd.domain.Inquiry;

public interface InquiryMapper {
	
	public void create(Inquiry inquiry) throws Exception;
	
	public void admincreate(Inquiry inquiry) throws Exception;
	
	public Inquiry read(Integer inquiryNo) throws Exception;
	
	public void update(Inquiry inquiry) throws Exception;
	
	public void delete(Integer inquiryNo) throws Exception;
	
	public List<Inquiry> list(PageRequest pageRequest) throws Exception;

	public int count(PageRequest pageRequest) throws Exception;

}
