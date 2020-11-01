package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.ProvinceDetail;
import org.hdcd.mapper.ProvinceDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceDetailServiceImpl implements ProvinceDetailService {

	@Autowired
	private ProvinceDetailMapper mapper;
	
	@Override
	public void register(ProvinceDetail provinceDetail) throws Exception {
		mapper.create(provinceDetail);
	}
	
	@Override
	public ProvinceDetail read(Integer cityNo) throws Exception {
		return mapper.read(cityNo);
	}
	
	@Override
	public void modify(ProvinceDetail provinceClass) throws Exception {
		mapper.update(provinceClass);
	}
	
	@Override
	public void remove(Integer cityNo) throws Exception {
		mapper.delete(cityNo);
	}
	
	@Override
	public List<ProvinceDetail> list() throws Exception {
		return mapper.list();
	}
	
}
