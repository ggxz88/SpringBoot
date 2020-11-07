package org.hdcd.mapper;

import java.util.List;

import org.hdcd.common.domain.CodeLabelValue;

public interface ProvinceMapper {

	public List<CodeLabelValue> getProvinceClassList() throws Exception;
	
	public List<CodeLabelValue> getProvinceList(String provinceName) throws Exception;
	
	public List<CodeLabelValue> getcityList(String provinceName, String title) throws Exception;
	
	public List<CodeLabelValue> getdayList(String city, String title) throws Exception;
	
}
