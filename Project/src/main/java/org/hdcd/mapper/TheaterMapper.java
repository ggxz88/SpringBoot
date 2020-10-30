package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.Theater;

public interface TheaterMapper {
	
	public void create(Theater theater) throws Exception;
	
	public Theater read(Integer theaterNo) throws Exception;
	
	public void update(Theater theater) throws Exception;
	
	public void delete(Integer theaterNo) throws Exception;
	
	public List<Theater> list() throws Exception;

}
