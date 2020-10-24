package org.hdcd.domain;

import java.io.Serializable;
import java.util.Date;

public class ChargePoint implements Serializable {

	private static final long serialVersionUID = 818690516659247392L;
	
	private int historyNo;
	
	private String userId;
	
	private int amount;
	
	private Date regDate;

	public int getHistoryNo() {
		return historyNo;
	}

	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
