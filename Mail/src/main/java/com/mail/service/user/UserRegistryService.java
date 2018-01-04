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
import com.mail.util.PasswordEncode;
@Service
public class UserRegistryService {
	@Autowired
	private UserDao userdao;
	@Autowired
	private PasswordEncode pe;
	@Autowired
	private MailUserDao mailuserdao;
	
	@Transactional
	public boolean registry(RegistryUser user) throws Exception{
		if(user==null){
			return false;
		}
		User u=new User();
		MailUserDomain mu=new MailUserDomain();
		
		u.setUsername(user.getName());
		u.setPwdHash(pe.encode(user.getPassword()));
		mu.setUserName(user.getName());
		mu.setPassword(user.getPassword());
		mu.setMuid(user.getRid());
		mu.setAge(user.getAge());
		mu.setSex(user.getSex());
		mu.setPhoneNumber(user.getPhoneNumber());
		u.setMailuserdomain(mu);
		System.out.println("success");
		userdao.save(u);
		return true;
	}
	
	public boolean checkUser(String name){
		User user=userdao.check(name);
		if(user!=null){
			return false;
		}
		return true;
	}
	@Transactional
	public long getTotalRecord(Class<MailUserDomain> user){
		return mailuserdao.getTotalRecord(user);
	}
}
