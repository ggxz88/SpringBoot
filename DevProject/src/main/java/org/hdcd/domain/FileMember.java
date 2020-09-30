package org.hdcd.domain;

import org.springframework.web.multipart.MultipartFile;

public class FileMember {

	private String userId;
	
	private String password;
	
	//MultipartFile 타입의 멤버변수를 선언한다.
	private MultipartFile picture;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	
}
