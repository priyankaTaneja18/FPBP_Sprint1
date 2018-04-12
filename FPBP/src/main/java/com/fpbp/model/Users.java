package com.fpbp.model;

public class Users {
	private String emailId;
	private String password;
	
	public Users() {
	}
	public Users(String emailId, String password) {
		//super();
		this.emailId = emailId;
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
