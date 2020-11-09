package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Screen;
import org.hdcd.domain.Seat;
import org.hdcd.mapper.ScreenMapper;
import org.hdcd.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScreenServiceImpl implements ScreenService {

	@Autowired
	private ScreenMapper screenMapper;
	
	@Autowired
	private SeatMapper seatMapper;
	
	@Transactional
	@Override
	public void register(Screen screen) throws Exception {
		screenMapper.create(screen);
		
		int col = screen.getScreenCol();
		int row = screen.getScreenRow();
		
		
		for(int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Seat seat = new Seat();
				
				seat.setCity(screen.getCity());
				seat.setScreenName(screen.getScreenName());
				
				if (i == 0) {
					seat.setSeatId("A" + j);
		        } else if (i == 1) {
		        	seat.setSeatId("B" + j);
		        } else if (i == 2) {
		        	seat.setSeatId("C" + j);
		        } else if (i == 3) {
		        	seat.setSeatId("D" + j);
		        } else if (i == 4) {
		        	seat.setSeatId("E" + j);
		        } else if (i == 5) {
		        	seat.setSeatId("F" + j);
		        } else if (i == 6) {
		        	seat.setSeatId("G" + j);
		        } else if (i == 7) {
		        	seat.setSeatId("H" + j);
		        } else if (i == 8) {
		        	seat.setSeatId("I" + j);
		        } else if (i == 9 ) {
		        	seat.setSeatId("J" + j);
		        }
				
				screenMapper.createSeat(seat);
			}
			
		}
	}
	
	@Override
	public Screen read(String city, String screenName) throws Exception {
		return screenMapper.read(city, screenName);
	}
	
	@Transactional
	@Override
	public void modify(Screen screen) throws Exception {
		String screenName = screen.getScreenName();
		String city = screen.getCity();		
		
		seatMapper.deleteall(city, screenName);
		
		screenMapper.update(screen);
		
		int col = screen.getScreenCol();
		int row = screen.getScreenRow();
		
		for(int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Seat seat = new Seat();
				
				seat.setCity(screen.getCity());
				seat.setScreenName(screen.getScreenName());
				
				if (i == 0) {
					seat.setSeatId("A" + j);
		        } else if (i == 1) {
		        	seat.setSeatId("B" + j);
		        } else if (i == 2) {
		        	seat.setSeatId("C" + j);
		        } else if (i == 3) {
		        	seat.setSeatId("D" + j);
		        } else if (i == 4) {
		        	seat.setSeatId("E" + j);
		        } else if (i == 5) {
		        	seat.setSeatId("F" + j);
		        } else if (i == 6) {
		        	seat.setSeatId("G" + j);
		        } else if (i == 7) {
		        	seat.setSeatId("H" + j);
		        } else if (i == 8) {
		        	seat.setSeatId("I" + j);
		        } else if (i == 9 ) {
		        	seat.setSeatId("J" + j);
		        }
				
				screenMapper.createSeat(seat);
			}
			
		}
	}
	
	@Override
	public void remove(String city, String screenName) throws Exception {
		screenMapper.delete(city, screenName);
	}
	
	@Override
	public List<Screen> list() throws Exception {
		return screenMapper.list();
	}
}
