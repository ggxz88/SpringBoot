package org.hdcd.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

public class Address implements Serializable {

	private static final long serialVersionUID = 4520922196788424774L;

	/*
	private String postCode;
	
	private String location;

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	*/
	
	//중첩된 자바빈즈 입력값 검증
	
	//문자열이 null이 아니고 trim한 길이가 0보다 크다는 것을 검사한다.
	@NotBlank
	private String postCode;
	
	//문자열이 null이 아니고 trim한 길이가 0보다 크다는 것을 검사한다.
	@NotBlank
	private String location;

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
