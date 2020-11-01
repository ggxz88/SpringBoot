package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.ProvinceDetail;

public interface ProvinceDetailMapper {
	
	public void create(ProvinceDetail provinceDetail) throws Exception;
	
	public ProvinceDetail read(Integer cityNo) throws Exception;
	
	public void update(ProvinceDetail provinceClass) throws Exception;
	
	public void delete(Integer cityNo) throws Exception;
	
	public List<ProvinceDetail> list() throws Exception;
}
