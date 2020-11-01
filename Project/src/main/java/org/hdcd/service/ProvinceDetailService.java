package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.ProvinceDetail;

public interface ProvinceDetailService {
	
	public void register(ProvinceDetail provinceDetail) throws Exception;
	
	public ProvinceDetail read(Integer cityNo) throws Exception;
	
	public void modify(ProvinceDetail provinceClass) throws Exception;
	
	public void remove(Integer cityNo) throws Exception;
	
	public List<ProvinceDetail> list() throws Exception;
}
