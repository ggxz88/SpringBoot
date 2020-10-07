package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.Item;
import org.springframework.data.repository.query.Param;

public interface ItemMapper {
	
	public void create(Item item) throws Exception;
	
	public Item read(Integer itemId) throws Exception;
	
	public void update(Item item) throws Exception;
	
	public void delete(Integer itemId) throws Exception;
	
	public List<Item> list() throws Exception;
	
	public String getPicture(Integer itemId) throws Exception;
	
	//여러 개의 이미지 업로드
	//public String getPicture2(Integer itemId) throws Exception;

	//비동기 방식 업로드
	public void addAttach(String fullName) throws Exception;
	
	public List<String> getAttach(Integer itemId) throws Exception;
	
	public void deleteAttach(Integer itemId) throws Exception;
	
	public void replaceAttach(@Param("fullName") String fullName, @Param("itemId") Integer itemId) throws Exception;
}
