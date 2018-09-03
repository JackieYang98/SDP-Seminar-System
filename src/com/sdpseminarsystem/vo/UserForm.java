package com.sdpseminarsystem.vo;

public class UserForm {
	
	private String userId;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private char userTypeFlag;
	
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
	public char getUserTypeFlag() {
		return userTypeFlag;
	}
	public void setUserTypeFlag(char userTypeFlag) {
		this.userTypeFlag = userTypeFlag;
	}
}
