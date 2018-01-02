package com.mail.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	public void test(){
		RegistryUser registryUser=new RegistryUser();
		
		registryUser.setRid(0);
		registryUser.setName("Tobby");
		registryUser.setPassword("123000");
		registryUser.setAge(11);
		registryUser.setPhoneNumber("1222");
		registryUser.setSex("male");
		test.registry(registryUser);
	}
}
