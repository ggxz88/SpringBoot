package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Review;
import org.hdcd.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewMapper mapper;
	
	@Override
	public void register(Review review) throws Exception {
		mapper.create(review);
	}
	
	@Override
	public Review read(Integer reviewNo) throws Exception {
		return mapper.read(reviewNo);
	}
	
	@Override
	public void modify(Review review) throws Exception {
		mapper.update(review);
	}
	
	@Override
	public void remove(int reviewNo) throws Exception {
		mapper.delete(reviewNo);
	}
	
	@Override
	public List<Review> list(int movieNo) throws Exception {
		return mapper.list(movieNo);
	}

}
