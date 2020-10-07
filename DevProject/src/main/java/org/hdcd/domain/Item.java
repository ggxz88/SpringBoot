package org.hdcd.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Item implements Serializable {

	private static final long serialVersionUID = -7171819535329599881L;
	
	private Integer itemId;
	
	private String itemName;
	
	private Integer price;
	
	private String description;
	
	//이미지 업로드
	//private MultipartFile picture;
	private List<MultipartFile> pictures;
	
	//private String pictureUrl;

	//여러 개의 이미지 업로드
	//private String pictureUrl2;
	
	//비동기식 파일 업로드
	private String[] files;
	
	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	*/
	
	public List<MultipartFile> getPictures() {
		return pictures;
	}

	public void setPictures(List<MultipartFile> pictures) {
		this.pictures = pictures;
	}
	
	/*
	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getPictureUrl2() {
		return pictureUrl2;
	}

	public void setPictureUrl2(String pictureUrl2) {
		this.pictureUrl2 = pictureUrl2;
	}
	*/
	
}
