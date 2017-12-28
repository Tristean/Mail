package com.mail.service;

import java.util.List;

import com.mail.domain.MailUserDomain;

public interface MailUserService {
public boolean add(MailUserDomain user);
	
	public boolean delete(int muid);
	
	public List selectById(int id);
	
	public boolean update(int id);
}
