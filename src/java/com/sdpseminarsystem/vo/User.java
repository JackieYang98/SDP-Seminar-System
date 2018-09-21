package com.sdpseminarsystem.vo;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 2085844320482884610L;
	
	private String userId;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userPassword;
	private char userTypeFlag;
	
        public User(){}
        public User(String id, String fn, String ln, String email, String pass, char type){
            this.userId = id;
            this.userFirstName = fn;
            this.userLastName = ln;
            this.userEmail = email;
            this.userPassword = pass;
            this.userTypeFlag = type;
        }
        
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
	public char getUserTypeFlag() {
		return userTypeFlag;
	}
	public void setUserTypeFlag(char userTypeFlag) {
		this.userTypeFlag = userTypeFlag;
	}
}
