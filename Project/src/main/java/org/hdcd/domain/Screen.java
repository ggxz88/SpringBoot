package org.hdcd.domain;

import java.io.Serializable;

public class Screen implements Serializable {

	private static final long serialVersionUID = 5943467863325968361L;
		
	private int screenNo; /*영화 상영관 번호*/
	
	private int theaterNo; /*영화관 번호*/
	
	private String screenName; /*영화 상영관 이름*/
	
	private int screenCol; /*영화 상영관 행*/
	
	private int screenRow; /*영화 상영관 열*/
	
	public int getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}

	public int getTheaterNo() {
		return theaterNo;
	}

	public void setTheaterNo(int theaterNo) {
		this.theaterNo = theaterNo;
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
