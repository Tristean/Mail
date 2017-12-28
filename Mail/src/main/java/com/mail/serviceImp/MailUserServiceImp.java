package com.mail.serviceImp;

import java.util.List;

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
	public boolean delete(int mid) {
		// TODO Auto-generated method stub
		return mailuserdao.delete(mid);
	}


	@Override
	public List selectById(int id) {
		// TODO Auto-generated method stub
		return mailuserdao.selectById(id);
	}

	@Override
	public boolean update(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
