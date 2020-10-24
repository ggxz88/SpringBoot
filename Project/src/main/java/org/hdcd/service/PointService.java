package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.ChargePoint;

public interface PointService {
	
	public void charge(ChargePoint chargePoint) throws Exception;
	
	public List<ChargePoint> list(String userId) throws Exception;
	
}
