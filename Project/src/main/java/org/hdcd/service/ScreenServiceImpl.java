package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Screen;
import org.hdcd.mapper.ScreenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenServiceImpl implements ScreenService {

	@Autowired
	private ScreenMapper screenMapper;
	
	@Override
	public void register(Screen screen) throws Exception {
		screenMapper.create(screen);
	}
	
	@Override
	public Screen read(Integer screenNo) throws Exception {
		return screenMapper.read(screenNo);
	}
	
	@Override
	public void modify(Screen screen) throws Exception {
		screenMapper.update(screen);
	}
	
	@Override
	public void remove(Integer screenNo) throws Exception {
		screenMapper.delete(screenNo);
	}
	
	@Override
	public List<Screen> list() throws Exception {
		return screenMapper.list();
	}
}
