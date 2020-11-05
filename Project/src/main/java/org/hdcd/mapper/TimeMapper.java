package org.hdcd.mapper;

import java.util.List;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.domain.Time;

public interface TimeMapper {
	
	public void create(Time time) throws Exception;
	
	public Time read(Integer timeNo) throws Exception;
	
	public void update(Time time) throws Exception;
	
	public void delete(Integer timeNo) throws Exception;
	
	public List<Time> list() throws Exception;
	
	public List<CodeLabelValue> screenList(String city) throws Exception;
	
	public List<CodeLabelValue> movieList() throws Exception;
	
}
