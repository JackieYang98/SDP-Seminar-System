package com.sdpseminarsystem.vo;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 6086326671389480875L;
	
	private String userId;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userPassword;
	private Character userTypeFlag;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Character getUserTypeFlag() {
		return userTypeFlag;
	}
	public void setUserTypeFlag(Character userTypeFlag) {
		this.userTypeFlag = userTypeFlag;
	}
}
