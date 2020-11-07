package org.hdcd.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Reservation implements Serializable {

	private static final long serialVersionUID = -2351700127905787118L;

	private int movieReserveNo; /*예약 번호*/
	
    private String reserveInfo; /*에약 정보*/
	
    private String userId;
    
	private String title; /*영화 제목*/
    
	private String provinceName; /*도시 이름*/
	
    private String city; /*영화관*/
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime showTime;
	
    private String screenName; /*영화 상영관 이름*/
	
    private String seatId; /*좌석 이름*/
    
	private int price;

	public int getMovieReserveNo() {
		return movieReserveNo;
	}

	public void setMovieReserveNo(int movieReserveNo) {
		this.movieReserveNo = movieReserveNo;
	}

	public String getReserveInfo() {
		return reserveInfo;
	}

	public void setReserveInfo(String reserveInfo) {
		this.reserveInfo = reserveInfo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
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
