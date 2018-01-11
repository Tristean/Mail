package com.mail.domain;

import javax.persistence.Entity;

@Entity
public class User {
	private String username;
	private String pwdHash;
	private String pwdAlgorithm="SHA";
	private int useForwarding=0;
	private String forwardDestination;
	private int useAlias=0;
	private String alias;
	private MailUserDomain mailuserdomain;
	
	
	public MailUserDomain getMailuserdomain() {
		return mailuserdomain;
	}
	public void setMailuserdomain(MailUserDomain mailuserdomain) {
		this.mailuserdomain = mailuserdomain;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwdHash() {
		return pwdHash;
	}
	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}
	public String getPwdAlgorithm() {
		return pwdAlgorithm;
	}
	public void setPwdAlgorithm(String pwdAlgorithm) {
		this.pwdAlgorithm = pwdAlgorithm;
	}
	public int getUseForwarding() {
		return useForwarding;
	}
	public void setUseForwarding(int useForwarding) {
		this.useForwarding = useForwarding;
	}
	public String getForwardDestination() {
		return forwardDestination;
	}
	public void setForwardDestination(String forwardDestination) {
		this.forwardDestination = forwardDestination;
	}
	public int getUseAlias() {
		return useAlias;
	}
	public void setUseAlias(int useAlias) {
		this.useAlias = useAlias;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	
}
