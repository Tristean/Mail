package com.mail.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mail.domain.MailUserDomain;
import com.mail.service.MailUserService;

public class MailUserDomainTest {
	private ApplicationContext app;
	private MailUserService mus;
	{
		app=new ClassPathXmlApplicationContext("application.xml");
		mus=app.getBean(MailUserService.class);
	}
	@Test
	public void test(){
		MailUserDomain mud=new MailUserDomain();
		mud.setMuid(0);
		mud.setUserName("ss");
		mud.setPassword("test");
		mus.add(mud);
	}
	
}
