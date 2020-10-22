package org.hdcd.domain;

import java.io.Serializable;
import java.util.Date;

public class Inquiry implements Serializable {

	private static final long serialVersionUID = -670046239212434556L;
	
	private int inquiryNo;
	
	private String title;
	
	private String content;
	
	private String writer;
	
	private Date regDate;
	
	private String title_plus;		
	
	//계층형 게시판 
	
	// 원글 번호
	private int originNo;
	
	// 원글(답글 포함)에 대한 순서
	private int groupOrd;
	
	// 답글 계층
	private int groupLayer;

	public String getTitle_plus() {
		return title_plus;
	}

	public void setTitle_plus(String title_plus) {
		title_plus = "└";
		
		this.title_plus = title_plus;
	}

	public int getInquiryNo() {
		return inquiryNo;
	}

	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getOriginNo() {
		return originNo;
	}

	public void setOriginNo(int originNo) {
		this.originNo = originNo;
	}

	public int getGroupOrd() {
		return groupOrd;
	}

	public void setGroupOrd(int groupOrd) {
		this.groupOrd = groupOrd;
	}

	public int getGroupLayer() {
		return groupLayer;
	}

	public void setGroupLayer(int groupLayer) {
		this.groupLayer = groupLayer;
	}
}
