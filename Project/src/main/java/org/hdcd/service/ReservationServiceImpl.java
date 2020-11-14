package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Member;
import org.hdcd.domain.PayPoint;
import org.hdcd.domain.Reservation;
import org.hdcd.domain.Seat;
import org.hdcd.exception.NotEnoughPointException;
import org.hdcd.mapper.PointMapper;
import org.hdcd.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired 
	private ReservationMapper mapper;
	
	@Autowired
	private PointMapper pointMapper;
	
	@Transactional
	@Override
	public void register(Member member, Reservation reservation) throws Exception {
		String userId = member.getUserId();
		int point = member.getPoint();
		reservation.setUserId(userId);
		int price = reservation.getPrice();
		int movieReserveNo = reservation.getMovieReserveNo();
		
		if(point < price) {
			throw new NotEnoughPointException("There is Not Enough Point.");
		}
		
		PayPoint payPoint = new PayPoint();
		payPoint.setUserId(userId);
		payPoint.setAmount(price);
		payPoint.setMovieReserveNo(movieReserveNo);
		
		pointMapper.pay(payPoint);
		pointMapper.createPayHistory(payPoint);
		
		mapper.create(reservation);
		
	}
	
	@Override
	public Reservation read(Integer movieReserveNo) throws Exception {
		return mapper.read(movieReserveNo);
	}
	
	@Override
	public List<Reservation> listAll() throws Exception {
		return mapper.listAll();
	}
	
	@Override
	public List<Reservation> list(String userId) throws Exception {
		return mapper.list(userId);
	}
	
	@Override
	public List<Seat> getSeatList(String showTime, String showDate, String city, String title) throws Exception {
		return mapper.getSeatList(showTime, showDate, city, title);
	}
	
	
}
