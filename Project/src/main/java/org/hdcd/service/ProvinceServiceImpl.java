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
	public List<CodeLabelValue> getProvinceList(String provinceName) throws Exception {
		return mapper.getProvinceList(provinceName);
	}

	@Override
	public List<CodeLabelValue> getcityList(String provinceName, String title) throws Exception {
		return mapper.getcityList(provinceName, title);
	}
	
	@Override
	public List<CodeLabelValue> getdayList(String city, String title) throws Exception {
		return mapper.getdayList(city, title);
	}
	
}
