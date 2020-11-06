package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.ChargePoint;
import org.hdcd.domain.PayPoint;

public interface PointService {
	
	public void charge(ChargePoint chargePoint) throws Exception;
	
	public List<ChargePoint> list(String userId) throws Exception;
	
	public List<PayPoint> listPayHistory(String userId) throws Exception;
	
}
