package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Theater;
import org.hdcd.mapper.TheaterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterServiceImpl implements TheaterService {
	
	@Autowired
	private TheaterMapper theaterMapper;
	
	@Override
	public void register(Theater theater) throws Exception {
		theaterMapper.create(theater);
	}
	
	@Override
	public Theater read(Integer theaterNo) throws Exception {
		return theaterMapper.read(theaterNo);
	}
	
	@Override
	public void modify(Theater theater) throws Exception {
		theaterMapper.update(theater);
	}
	
	@Override
	public void remove(Integer theaterNo) throws Exception {
		theaterMapper.delete(theaterNo);
	}
	
	@Override
	public List<Theater> list() throws Exception {
		return theaterMapper.list();
	}

}
