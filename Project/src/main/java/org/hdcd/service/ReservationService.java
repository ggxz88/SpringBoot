package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Member;
import org.hdcd.domain.Reservation;
import org.hdcd.domain.Seat;

public interface ReservationService {
	
	public void register(Member member, Reservation reservation) throws Exception;
	
	public Reservation read(Integer movieReserveNo) throws Exception;
	
	public List<Reservation> listAll() throws Exception;
	
	public List<Reservation> list(String userId) throws Exception;

	public List<Seat> getSeatList(String showTime, String showDate, String city, String title) throws Exception;
	
}
