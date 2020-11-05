package org.hdcd.service;

import java.util.List;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.domain.Time;
import org.hdcd.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {
	
	@Autowired
	private TimeMapper timeMapper;
	
	@Override
	public void register(Time time) throws Exception {
		timeMapper.create(time);
	}
	
	@Override
	public Time read(Integer timeNo) throws Exception {
		return timeMapper.read(timeNo);
	}
	
	@Override
	public void modify(Time time) throws Exception {
		timeMapper.update(time);
	}
	
	@Override
	public void remove(Integer timeNo) throws Exception {
		timeMapper.delete(timeNo);
	}
	
	@Override
	public List<Time> list() throws Exception {
		return timeMapper.list();
	}
	
	@Override
	public List<CodeLabelValue> screenList(String city) throws Exception {
		return timeMapper.screenList(city);
	}

	@Override
	public List<CodeLabelValue> movieList() throws Exception {
		return timeMapper.movieList();
	}

}
