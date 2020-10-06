package org.hdcd.service;

import java.util.List;

import org.hdcd.dao.BoardDAO;
import org.hdcd.domain.Board;
import org.hdcd.mapper.BoardMapper;
import org.hdcd.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	//스프링 JDBC
	/*
	@Autowired
	private BoardDAO dao;
	*/
	
	//JPA
	@Autowired
	private BoardRepository boardRepository;
	private BoardMapper mapper;
	
	@Override
	public void register(Board board) throws Exception {
		//dao.create(board);
		mapper.create(board);
	}
	
	@Override
	public Board read(Integer boardNo) throws Exception {
		//return dao.read(boardNo);
		return mapper.read(boardNo);
	}
	
	@Override
	public void modify(Board board) throws Exception {
		//dao.update(board);
		mapper.update(board);
	}
	
	@Override
	public void remove(Integer boardNo) throws Exception {
		//dao.delete(boardNo);
		mapper.delete(boardNo);
	}
	
	@Override
	public List<Board> list() throws Exception {
		//return dao.list();
		return mapper.list();
	}
	
	@Override
	public List<Board> search(String title) throws Exception {
		return mapper.search(title);
	}


}
