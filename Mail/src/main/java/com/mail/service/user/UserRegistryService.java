package com.mail.service.user;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mail.dao.MailUserDao;
import com.mail.dao.UserDao;
import com.mail.dao.imp.UserDaoImp;
import com.mail.domain.MailUserDomain;
import com.mail.domain.User;
import com.mail.domain.form.RegistryUser;
@Service
public class UserRegistryService {
	@Autowired
	private UserDao userdao;
	
	@Transactional
	public boolean registry(RegistryUser user){
		if(user==null){
			return false;
		}
		User u=new User();
		MailUserDomain mu=new MailUserDomain();
		
		u.setUsername(user.getName());
		u.setPwdHash(user.getPassword());
		mu.setMuid(user.getRid());
		mu.setAge(user.getAge());
		mu.setSex(user.getSex());
		mu.setPhoneNumber(user.getPhoneNumber());
		System.out.println("success");
		userdao.save(u);
		return true;
	}
	
	
}
