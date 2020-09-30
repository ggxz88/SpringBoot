package org.hdcd.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Card implements Serializable {

	private static final long serialVersionUID = -1555464460892895832L;

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

}
