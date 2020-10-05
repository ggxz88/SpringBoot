package org.hdcd.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

public class Card implements Serializable {

	private static final long serialVersionUID = -1555464460892895832L;

	/*
	private String no;
	
	//Date 타입 프로퍼티 변환 처리
	@DateTimeFormat(pattern="yyyyMMdd")
	private Date validMonth;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getValidMonth() {
		return validMonth;
	}

	public void setValidMonth(Date validMonth) {
		this.validMonth = validMonth;
	}
	*/
	
	//문자열이 null이 아니고 trim한 길이가 0보다 크다는 것을 검사한다.
	@NotBlank
	private String no;
	
	//미래 날짜인지를 검사한다.
	@Future
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date validMonth;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getValidMonth() {
		return validMonth;
	}

	public void setValidMonth(Date validMonth) {
		this.validMonth = validMonth;
	}
	
}
