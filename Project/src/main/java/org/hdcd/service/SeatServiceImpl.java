package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Seat;
import org.hdcd.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatMapper seatMapper;
	

	@Override
	public Seat read(Integer seatNo) throws Exception {
		return seatMapper.read(seatNo);
	}
	
	@Override
	public void modify(Seat seat) throws Exception {
		seatMapper.update(seat);
	}
	
	@Override
	public List<Seat> list(String screenName) throws Exception {
		return seatMapper.list(screenName);
	}

}
