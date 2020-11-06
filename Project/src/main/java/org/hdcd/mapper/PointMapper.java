package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.ChargePoint;
import org.hdcd.domain.PayPoint;

public interface PointMapper {

	public void create(ChargePoint chargePoint) throws Exception;
	
	public void charge(ChargePoint chargePoint) throws Exception;
	
	public List<ChargePoint> list(String userId) throws Exception;
	
	public void createPayHistory(PayPoint payPoint) throws Exception;
	
	public List<PayPoint> listPayHistory(String userId) throws Exception;
	
	public void pay(PayPoint payPoint) throws Exception;
	
}
