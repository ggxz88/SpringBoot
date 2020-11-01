package org.hdcd.service;

import java.util.List;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.mapper.ProvinceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {
	
	@Autowired
	private ProvinceMapper mapper;
	
	@Override
	public List<CodeLabelValue> getProvinceClassList() throws Exception {
		return mapper.getProvinceClassList();
	}
	
	@Override
	public List<CodeLabelValue> getProvinceList(Integer provinceNo) throws Exception {
		return mapper.getProvinceList(provinceNo);
	}


}
