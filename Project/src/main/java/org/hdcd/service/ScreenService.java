package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Screen;

public interface ScreenService {

	public void register(Screen screen) throws Exception;
	
	public Screen read(Integer screenNo) throws Exception;
	
	public void modify(Screen screen) throws Exception;
	
	public void remove(Integer screenNo) throws Exception;
	
	public List<Screen> list() throws Exception;
	
}
