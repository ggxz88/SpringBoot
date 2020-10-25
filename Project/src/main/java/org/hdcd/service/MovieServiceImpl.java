package org.hdcd.service;

import java.util.List;

import org.hdcd.common.domain.PageRequest;
import org.hdcd.domain.Movie;
import org.hdcd.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper mapper;
	
	@Override
	public void register(Movie movie) throws Exception {
		mapper.create(movie);
	}
	
	@Override
	public Movie read(Integer movieNo) throws Exception {
		return mapper.read(movieNo);
	}
	
	@Override
	public void modify(Movie movie) throws Exception {
		mapper.update(movie);
	}
	
	@Override
	public void remove(Integer movieNo) throws Exception {
		mapper.delete(movieNo);
	}
	
	@Override
	public List<Movie> list(PageRequest pageRequest) throws Exception {
		return mapper.list(pageRequest);
	}

	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return mapper.count(pageRequest);
	}
	
	@Override
	public String getPoster(Integer movieNo) throws Exception {
		return mapper.getPoster(movieNo);
	}
	
	@Override
	public String getStill1(Integer movieNo) throws Exception {
		return mapper.getStill1(movieNo);
	}
	
	@Override
	public String getStill2(Integer movieNo) throws Exception {
		return mapper.getStill2(movieNo);
	}
	
	@Override
	public String getStill3(Integer movieNo) throws Exception {
		return mapper.getStill3(movieNo);
	}
	
	@Override
	public String getStill4(Integer movieNo) throws Exception {
		return mapper.getStill4(movieNo);
	}
	
}
