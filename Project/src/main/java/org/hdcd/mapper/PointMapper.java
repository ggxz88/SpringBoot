package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.ChargePoint;

public interface PointMapper {

	public void create(ChargePoint chargePoint) throws Exception;
	
	public void charge(ChargePoint chargePoint) throws Exception;
	
	public List<ChargePoint> list(String userId) throws Exception;
}
