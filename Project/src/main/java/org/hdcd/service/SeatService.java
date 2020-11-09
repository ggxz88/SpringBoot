package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Seat;

public interface SeatService {
			
	public Seat read(Integer seatNo) throws Exception;
	
	public void modify(Seat seat) throws Exception;
		
	public List<Seat> list(String city, String screenName) throws Exception;
	
}
