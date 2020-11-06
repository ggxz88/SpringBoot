package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.ChargePoint;
import org.hdcd.domain.PayPoint;
import org.hdcd.mapper.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointServiceImpl implements PointService {

	@Autowired
	private PointMapper mapper;
	
	@Override
	public void charge(ChargePoint chargePoint) throws Exception {
		mapper.charge(chargePoint);
		mapper.create(chargePoint);
	}
	
	@Override
	public List<ChargePoint> list(String userId) throws Exception {
		return mapper.list(userId);
	}
	
	@Override
	public List<PayPoint> listPayHistory(String userId) throws Exception {
		return mapper.listPayHistory(userId);
	}
	
}
