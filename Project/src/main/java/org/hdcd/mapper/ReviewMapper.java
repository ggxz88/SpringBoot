package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.Review;


public interface ReviewMapper {
	
	public void create(Review review) throws Exception;
	
	public Review read(Integer reviewNo) throws Exception;
	
	public void update(Review review) throws Exception;
	
	public void delete(Integer reviewNo) throws Exception;
	
	public List<Review> list(Integer movieNo) throws Exception;

}
