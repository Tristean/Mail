package com.mail.domain;

import java.util.List;

public class MailUserDomain {
	private int muid;
	private String userName;
	private String password;
	private List<MailDomain>mails;

	
	public int getMuid() {
		return muid;
	}
	public void setMuid(int muid) {
		this.muid = muid;
	}

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<MailDomain> getMails() {
		return mails;
	}
	public void setMails(List<MailDomain> mails) {
		this.mails = mails;
	}
	
}
