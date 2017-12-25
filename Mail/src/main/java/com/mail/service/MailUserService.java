package com.mail.service;

import com.mail.domain.MailUserDomain;

public interface MailUserService {
public boolean add(MailUserDomain user);
	
	public boolean delete(int muid);
	
	public boolean selectAll();
	
	public boolean selectById(int id);
	
	public boolean update(int id);
}
