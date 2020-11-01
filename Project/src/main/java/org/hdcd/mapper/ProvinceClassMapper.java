package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.ProvinceClass;

public interface ProvinceClassMapper {
	
	public void create(ProvinceClass provinceClass) throws Exception;
	
	public ProvinceClass read(Integer provinceNo) throws Exception;
	
	public void update(ProvinceClass provinceClass) throws Exception;
	
	public void delete(Integer provinceNo) throws Exception;
	
	public List<ProvinceClass> list() throws Exception;
}
