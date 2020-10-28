package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Review;

public interface ReviewService {
	
	public void register(Review review) throws Exception;
	
	public Review read(Integer reviewNo) throws Exception;
	
	public void modify(Review review) throws Exception;
	
	public void remove(int reviewNo) throws Exception;
	
	public List<Review> list(int movieNo) throws Exception;
	
}
