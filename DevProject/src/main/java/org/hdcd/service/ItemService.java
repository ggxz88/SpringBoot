package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Item;

public interface ItemService {
	
	public void regist(Item item) throws Exception;
	
	public Item read(Integer itemId) throws Exception;
	
	public void modify(Item item) throws Exception;
	
	public void remove(Integer integer) throws Exception;
	
	public List<Item> list() throws Exception;
	
	public String getPicture(Integer itemId) throws Exception;

	//여러 개의 이미지 업로드
	//public String getPicture2(Integer itemId) throws Exception;
	
	//비동기 방식 업로드
	public List<String> getAttach(Integer itemId) throws Exception;
}
