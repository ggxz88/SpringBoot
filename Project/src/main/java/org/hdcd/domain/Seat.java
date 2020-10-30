package org.hdcd.domain;

import java.io.Serializable;

public class Seat implements Serializable {

	private static final long serialVersionUID = -415438151228067928L;
	
	private String screenNo; /*영화 상영관 번호*/
	
	private String seat; /*영화 좌석*/
    
	private int price; /*영화 가격*/
	
	public String getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(String screenNo) {
		this.screenNo = screenNo;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
