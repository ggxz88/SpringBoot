package org.hdcd.domain;

import java.io.Serializable;

public class Screen implements Serializable {

	private static final long serialVersionUID = 5943467863325968361L;
	
	private String provinceName; /*도시 이름*/
	
	private String city; /*상세 도시*/
	
	private int screenNo; /*영화 상영관 번호*/
	
	private String screenName; /*영화 상영관 이름*/
	
	private int screenCol; /*영화 상영관 행*/
	
	private int screenRow; /*영화 상영관 열*/
	
	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getScreenCol() {
		return screenCol;
	}

	public void setScreenCol(int screenCol) {
		this.screenCol = screenCol;
	}

	public int getScreenRow() {
		return screenRow;
	}

	public void setScreenRow(int screenRow) {
		this.screenRow = screenRow;
	}
	
}
