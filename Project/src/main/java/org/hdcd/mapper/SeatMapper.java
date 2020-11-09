package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.Seat;

public interface SeatMapper {
			
	public Seat read(Integer seatNo) throws Exception;
	
	public void update(Seat seat) throws Exception;
	
	public void deleteall(String city, String screenName) throws Exception;
		
	public List<Seat> list(String city, String screenName) throws Exception;
	
}
