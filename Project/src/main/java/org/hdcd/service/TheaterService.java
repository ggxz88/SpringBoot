package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Theater;


public interface TheaterService {
	
	public void register(Theater theater) throws Exception;
	
	public Theater read(Integer theaterNo) throws Exception;
	
	public void modify(Theater theater) throws Exception;
	
	public void remove(Integer theaterNo) throws Exception;
	
	public List<Theater> list() throws Exception;

}
