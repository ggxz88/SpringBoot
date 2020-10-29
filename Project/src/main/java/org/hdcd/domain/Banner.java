package org.hdcd.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class Banner implements Serializable {

	private static final long serialVersionUID = -658212877339310217L;
	
	private int bannerNo;
	
	private int movieNo;
	
	private String bannerName;
	
	private MultipartFile bannerPicture;
	
	private String bannerPictureUrl;

	public int getBannerNo() {
		return bannerNo;
	}

	public void setBannerNo(int bannerNo) {
		this.bannerNo = bannerNo;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public MultipartFile getBannerPicture() {
		return bannerPicture;
	}

	public void setBannerPicture(MultipartFile bannerPicture) {
		this.bannerPicture = bannerPicture;
	}

	public String getBannerPictureUrl() {
		return bannerPictureUrl;
	}

	public void setBannerPictureUrl(String bannerPictureUrl) {
		this.bannerPictureUrl = bannerPictureUrl;
	}
	
}
