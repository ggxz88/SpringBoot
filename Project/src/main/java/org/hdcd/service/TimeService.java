package org.hdcd.service;

import java.util.List;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.domain.Time;

public interface TimeService {
	
	public void register(Time time) throws Exception;
	
	public Time read(Integer timeNo) throws Exception;
	
	public void modify(Time time) throws Exception;
	
	public void remove(Integer timeNo) throws Exception;
	
	public List<Time> list() throws Exception;
	
	public List<CodeLabelValue> screenList(String city) throws Exception;
	
	public List<CodeLabelValue> movieList() throws Exception;

}
