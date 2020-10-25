package org.hdcd.service;

import java.util.List;

import org.hdcd.common.domain.PageRequest;
import org.hdcd.domain.Movie;

public interface MovieService {
	
	public void register(Movie movie) throws Exception;
	
	public Movie read(Integer movieNo) throws Exception;
	
	public void modify(Movie movie) throws Exception;
	
	public void remove(Integer movieNo) throws Exception;
	
	public List<Movie> list(PageRequest pageRequest) throws Exception;

	public int count(PageRequest pageRequest) throws Exception;
	
	public String getPoster(Integer movieNo) throws Exception;
	
	public String getStill1(Integer movieNo) throws Exception;
	
	public String getStill2(Integer movieNo) throws Exception;
	
	public String getStill3(Integer movieNo) throws Exception;
	
	public String getStill4(Integer movieNo) throws Exception;

}
