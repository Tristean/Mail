package com.mail.daoImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mail.dao.MailUserDao;
import com.mail.domain.MailUserDomain;
@Repository
public class MailUserDaoImp implements MailUserDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	private Session getSession(){
		return sessionfactory.getCurrentSession();
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

	@Override
	public boolean add(MailUserDomain user) {
		// TODO Auto-generated method stub
		if(user==null){
			return false;
		}
		getSession().save(user);
		return true;
	}
	
}
