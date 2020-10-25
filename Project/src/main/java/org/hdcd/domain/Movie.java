package org.hdcd.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class Movie implements Serializable {

	private static final long serialVersionUID = -5168775225323700880L;
	
	private int movieNo; /*영화 번호*/
	
	private String title; /*영화 제목*/
	
	private String genre; /*영화 장르*/
	
	private String nation; /*영화 국가*/
	
	private int runningTime; /*영화 상영 시간*/
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date openningDays; /*영화 개봉일*/
	
	private String director; /*영화 감독*/
	
	private String actors; /*영화 출연 배우*/
	
	private String ratings; /*영화 심의 등급*/
	
	private String summary; /*영화 소개*/
	
	private MultipartFile poster;
	
	private String posterUrl; /*영화 포스터*/
	
	private MultipartFile still1;
	
	private String still1Url; /*영화 스틸컷1*/
		
	private MultipartFile still2;
	
	private String still2Url; /*영화 스틸컷2*/
		
	private MultipartFile still3;
	
	private String still3Url; /*영화 스틸컷3*/
		
	private MultipartFile still4;
	
	private String still4Url; /*영화 스틸컷4*/
	
	private Date regDate;
		
	private boolean enabled;

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public Date getOpenningDays() {
		return openningDays;
	}

	public void setOpenningDays(Date openningDays) {
		this.openningDays = openningDays;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public MultipartFile getPoster() {
		return poster;
	}

	public void setPoster(MultipartFile poster) {
		this.poster = poster;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public MultipartFile getStill1() {
		return still1;
	}

	public void setStill1(MultipartFile still1) {
		this.still1 = still1;
	}

	public String getStill1Url() {
		return still1Url;
	}

	public void setStill1Url(String still1Url) {
		this.still1Url = still1Url;
	}

	public MultipartFile getStill2() {
		return still2;
	}

	public void setStill2(MultipartFile still2) {
		this.still2 = still2;
	}

	public String getStill2Url() {
		return still2Url;
	}

	public void setStill2Url(String still2Url) {
		this.still2Url = still2Url;
	}

	public MultipartFile getStill3() {
		return still3;
	}

	public void setStill3(MultipartFile still3) {
		this.still3 = still3;
	}

	public String getStill3Url() {
		return still3Url;
	}

	public void setStill3Url(String still3Url) {
		this.still3Url = still3Url;
	}

	public MultipartFile getStill4() {
		return still4;
	}

	public void setStill4(MultipartFile still4) {
		this.still4 = still4;
	}

	public String getStill4Url() {
		return still4Url;
	}

	public void setStill4Url(String still4Url) {
		this.still4Url = still4Url;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
		
}
