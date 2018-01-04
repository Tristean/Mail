package com.mail.domain;

import javax.persistence.Entity;

@Entity
public class User {
	private String username;
	private String pwdHash;
	private String pwdAlgorithm;
	private String useForwarding;
	private String forwardDestinationn;
	private String useAlias;
	private String aias;
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
	public String getUseForwarding() {
		return useForwarding;
	}
	public void setUseForwarding(String useForwarding) {
		this.useForwarding = useForwarding;
	}
	public String getForwardDestinationn() {
		return forwardDestinationn;
	}
	public void setForwardDestinationn(String forwardDestinationn) {
		this.forwardDestinationn = forwardDestinationn;
	}
	public String getUseAlias() {
		return useAlias;
	}
	public void setUseAlias(String useAlias) {
		this.useAlias = useAlias;
	}
	public String getAias() {
		return aias;
	}
	public void setAias(String aias) {
		this.aias = aias;
	}
	
	
}
