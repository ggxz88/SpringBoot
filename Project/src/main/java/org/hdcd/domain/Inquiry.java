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

}
