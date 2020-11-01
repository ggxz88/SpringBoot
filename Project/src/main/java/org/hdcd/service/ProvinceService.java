package org.hdcd.service;

import java.util.List;

import org.hdcd.common.domain.CodeLabelValue;

public interface ProvinceService {
	
	public List<CodeLabelValue> getProvinceClassList() throws Exception;
	
	public List<CodeLabelValue> getProvinceList(Integer provinceNo) throws Exception;

}
