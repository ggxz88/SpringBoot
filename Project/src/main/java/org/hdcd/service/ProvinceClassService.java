package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.ProvinceClass;

public interface ProvinceClassService {
	
	public void register(ProvinceClass provinceClass) throws Exception;
	
	public ProvinceClass read(Integer provinceNo) throws Exception;
	
	public void modify(ProvinceClass provinceClass) throws Exception;
	
	public void remove(Integer provinceNo) throws Exception;
	
	public List<ProvinceClass> list() throws Exception;
}
