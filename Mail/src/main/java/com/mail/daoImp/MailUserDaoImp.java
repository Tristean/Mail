package com.mail.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mail.dao.MailUserDao;
import com.mail.domain.MailDomain;
import com.mail.domain.MailUserDomain;
@Repository
public class MailUserDaoImp implements MailUserDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	private Session getSession(){
		return sessionfactory.getCurrentSession();
	}
	
	@Override
	public boolean delete(int mid) {
		// TODO Auto-generated method stub
		if(mid==0||mid<0){
			return false;
		}
		MailDomain mail=(MailDomain) getSession().get(MailDomain.class, mid);
		getSession().delete(mail);
		System.out.println("delete");
		return true;
	}


	@Override
	public List selectById(int id) {
		// TODO Auto-generated method stub
		String hql;
		Query query;
		List<MailUserDomain>list;
		
		hql="from MailDomain mail where mail.user.muid=?";
		query=getSession().createQuery(hql);
		query.setInteger(0, id);
		list=query.list();
		return list;
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
