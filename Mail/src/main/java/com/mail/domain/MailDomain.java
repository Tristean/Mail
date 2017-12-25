package com.mail.domain;

public class MailDomain {
	private int mid;
	
	private MailUserDomain user;
	
	private String content;

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}

	public MailUserDomain getUser() {
		return user;
	}
	public void setUser(MailUserDomain user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
