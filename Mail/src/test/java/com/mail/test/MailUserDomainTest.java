package com.mail.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mail.domain.MailDomain;
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
	@Test
	public void test2(){
		MailUserDomain mud=new MailUserDomain();
		MailDomain mail=new MailDomain();
		mud.setMuid(0);
		mud.setUserName("ss");
		mud.setPassword("test");
		mail.setMid(0);
		mail.setContent("i love you");
		mud.getMails().add(mail);
		mail.setUser(mud);
		mus.add(mud);
	}
	@Test
	public void test3(){
		List list=mus.selectById(1);
		System.out.println(list.size());
	}
	@Test
	public void test4(){
		mus.delete(1);
	}
}
