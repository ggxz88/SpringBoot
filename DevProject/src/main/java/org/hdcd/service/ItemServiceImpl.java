package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Item;
import org.hdcd.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl implements ItemService {

	
	@Autowired
	private ItemMapper mapper;

	
	@Override
	public void regist(Item item) throws Exception {
		mapper.create(item);
		
		//비동기식 파일 업로드
		
		String[] files = item.getFiles();
		
		if(files == null) {
			return;
		}
		
		for (String fileName : files) {
			mapper.addAttach(fileName);
		}
	}
	
	

	@Override
	public Item read(Integer itemId) throws Exception {
		return mapper.read(itemId);
	}
	
	@Override
	public void modify(Item item) throws Exception {
		mapper.update(item);
		
		//비동기식 파일 업로드
		Integer itemId = item.getItemId();
		
		mapper.deleteAttach(itemId);
		
		String[] files = item.getFiles();
		
		if(files == null) {
			return;
		}
		
		for (String fileName : files) {
			mapper.replaceAttach(fileName, itemId);
		}
	}
	
	@Transactional/*비동기식 파일 업로드 */
	@Override
	public void remove(Integer itemId) throws Exception {
		mapper.delete(itemId);
	}
	
	@Override
	public List<Item> list() throws Exception {
		return mapper.list();
	}
	
	@Override
	public String getPicture(Integer itemId) throws Exception {
		return mapper.getPicture(itemId);
	}
	
	//여러 개의 이미지 업로드
	/*
	@Override
	public String getPicture2(Integer itemId) throws Exception {
		return mapper.getPicture2(itemId);

	}
	*/
	
	//비동기 방식 업로드
	public List<String> getAttach(Integer itemId) throws Exception {
		return mapper.getAttach(itemId);
	}

}
