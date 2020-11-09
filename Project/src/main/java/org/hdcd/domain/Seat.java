package org.hdcd.domain;

import java.io.Serializable;

public class Seat implements Serializable {

	private static final long serialVersionUID = -415438151228067928L;
	
	private String city;
	
	private String screenName; /*영화 상영관 이름*/
	
	private int seatNo; /*좌석 번호*/
	
	private String seatId; /*영화 좌석*/
    
	private int price; /*영화 가격*/
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
