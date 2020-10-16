package org.hdcd.domain;

import java.io.Serializable;

public class MemberAuth implements Serializable {

	private static final long serialVersionUID = 9072561024282543899L;

	private String userId;
	private String auth;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getAuth() {
		return auth;
	}
	
	public void setAuth(String auth) {
		this.auth = auth;
	}
	

}
