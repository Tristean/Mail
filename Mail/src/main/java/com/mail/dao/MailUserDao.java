package com.mail.dao;

import java.util.List;

import com.mail.domain.MailUserDomain;

public interface MailUserDao {
	public boolean add(MailUserDomain user);
	
	public boolean delete(int mid);
	
	
	public List selectById(int id);
	
	public boolean update(int id);
}
