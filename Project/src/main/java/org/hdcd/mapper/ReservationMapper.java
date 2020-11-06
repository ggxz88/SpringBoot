package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.Reservation;

public interface ReservationMapper {
	
	public void create(Reservation reservation) throws Exception;
	
	public Reservation read(Integer movieReserveNo) throws Exception;
	
	public List<Reservation> listAll() throws Exception;
	
	public List<Reservation> list(String userId) throws Exception;

}
