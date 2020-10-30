package org.hdcd.domain;

import java.io.Serializable;

public class Theater implements Serializable {

	private static final long serialVersionUID = 1713906936947141859L;
	
	private String city;
	
	private int theaterNo;
	
	private String theater;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getTheaterNo() {
		return theaterNo;
	}

	public void setTheaterNo(int theaterNo) {
		this.theaterNo = theaterNo;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}
	
}
