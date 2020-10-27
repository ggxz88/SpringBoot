package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Reply;
import org.hdcd.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper mapper;
	
	@Override
	public void register(Reply reply) throws Exception {
		mapper.create(reply);
	}
	
	@Override
	public Reply read(Integer replyNo) throws Exception {
		return mapper.read(replyNo);
	}
	
	@Override
	public void modify(Reply reply) throws Exception {
		mapper.update(reply);
	}
	
	@Override
	public void remove(int replyNo) throws Exception {
		mapper.delete(replyNo);
	}
	
	@Override
	public List<Reply> list(int boardNo) throws Exception {
		return mapper.list(boardNo);
	}
	
}
