package com.mail.dao;

import com.mail.dao.basedao.MailBaseDao;
import com.mail.domain.User;

public interface UserDao extends MailBaseDao<User>{
	public User check(String userName);
}
