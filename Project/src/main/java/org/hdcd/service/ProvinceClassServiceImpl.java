package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.ProvinceClass;
import org.hdcd.mapper.ProvinceClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceClassServiceImpl implements ProvinceClassService {

	@Autowired
	private ProvinceClassMapper mapper;
	
	@Override
	public void register(ProvinceClass provinceClass) throws Exception {
		mapper.create(provinceClass);
	}
	
	@Override
	public ProvinceClass read(Integer provinceNo) throws Exception {
		return mapper.read(provinceNo);
	}
	
	@Override
	public void modify(ProvinceClass provinceClass) throws Exception {
		mapper.update(provinceClass);
	}
	
	@Override
	public void remove(Integer provinceNo) throws Exception {
		mapper.delete(provinceNo);
	}
	
	@Override
	public List<ProvinceClass> list() throws Exception {
		return mapper.list();
	}
}
