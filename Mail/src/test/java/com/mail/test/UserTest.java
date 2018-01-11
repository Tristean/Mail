package com.mail.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mail.domain.MailUserDomain;
import com.mail.domain.User;
import com.mail.domain.form.RegistryUser;
import com.mail.service.user.UserRegistryService;


public class UserTest {
	UserRegistryService test;
	ApplicationContext app;
	{
		app=new ClassPathXmlApplicationContext("application.xml");
		test=app.getBean(UserRegistryService.class);
	}
	@Test
	public void test() throws Exception{
		RegistryUser registryUser=new RegistryUser();
		
		registryUser.setName("buddy");
		registryUser.setPassword("buddy123");
		registryUser.setAge(11);
		registryUser.setPhoneNumber("1222");
		registryUser.setSex("male");
		test.registry(registryUser);
	}
	@Test
	public void test1(){
		String name="Tobby";
		boolean judge=test.checkUser(name);
		System.out.println(judge);
	}
	@Test
	public void test2(){
		test.getTotalRecord(MailUserDomain.class);
	}
}
