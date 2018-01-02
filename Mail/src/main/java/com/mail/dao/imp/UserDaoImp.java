package com.mail.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mail.dao.UserDao;
import com.mail.dao.basedao.MailBaseDaoImp;
import com.mail.domain.User;
@Service
public class UserDaoImp extends MailBaseDaoImp<User> implements UserDao {
	
	@Override
	public User check(String userName) {
		// TODO Auto-generated method stub
		User user=this.find(User.class, userName);
		if(user==null){
			return null;
		}
		return user;
	}	
}
