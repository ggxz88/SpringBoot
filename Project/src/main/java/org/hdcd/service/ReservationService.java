package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Member;
import org.hdcd.domain.Reservation;

public interface ReservationService {
	
	public void register(Member member, Reservation reservation) throws Exception;
	
	public Reservation read(Integer movieReserveNo) throws Exception;
	
	public List<Reservation> listAll() throws Exception;
	
	public List<Reservation> list(String userId) throws Exception;

}
