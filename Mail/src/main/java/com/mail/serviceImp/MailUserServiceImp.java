package com.mail.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail.dao.MailUserDao;
import com.mail.domain.MailUserDomain;
import com.mail.service.MailUserService;
@Service
public class MailUserServiceImp implements MailUserService {
	@Autowired
	private MailUserDao mailuserdao;
	
	@Override
	public boolean add(MailUserDomain user) {
		// TODO Auto-generated method stub
		return mailuserdao.add(user);
	}

	@Override
	public boolean delete(int muid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
