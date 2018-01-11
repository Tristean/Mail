package com.mail.service.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmtpAuth extends Authenticator {
	private String username;
	private String password;
	
	
	public SmtpAuth(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	protected PasswordAuthentication getPasswordAuthenticationn(){
		return new PasswordAuthentication(username,password);
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
