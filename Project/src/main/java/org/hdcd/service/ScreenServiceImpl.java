package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Screen;
import org.hdcd.domain.Seat;
import org.hdcd.mapper.ScreenMapper;
import org.hdcd.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenServiceImpl implements ScreenService {

	@Autowired
	private ScreenMapper screenMapper;
	
	@Autowired
	private SeatMapper seatMapper;
	
	@Override
	public void register(Screen screen) throws Exception {
		screenMapper.create(screen);
		
		int col = screen.getScreenCol();
		int row = screen.getScreenRow();
		
		for(int i = 0; i < (col * row); i++) {
			Seat seat = new Seat();
			
			seat.setScreenName(screen.getScreenName());
			
			screenMapper.createSeat(seat);
		}
	}
	
	@Override
	public Screen read(Integer screenNo) throws Exception {
		return screenMapper.read(screenNo);
	}
	
	@Override
	public void modify(Screen screen) throws Exception {
		String screenName = screen.getScreenName();
		
		seatMapper.deleteall(screenName);
		
		screenMapper.update(screen);
		
		int col = screen.getScreenCol();
		int row = screen.getScreenRow();
		
		for(int i = 0; i < (col * row); i++) {
			Seat seat = new Seat();
			
			seat.setScreenName(screen.getScreenName());
			
			screenMapper.createSeat(seat);
		}
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
