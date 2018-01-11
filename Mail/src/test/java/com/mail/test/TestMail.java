package com.mail.test;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

import com.mail.domain.MailDomain;
import com.mail.service.mail.send.SendMail;

public class TestMail {
	@Test
	public void test() throws Exception{
		MailDomain mailDomain=new MailDomain("test@zzMail.com","test123","<test@zzMail.com>",
											"<Ted@zzMail.com>,","test","这是测试");
		SendMail sendmail=new SendMail(mailDomain);
		sendmail.send();
	}
	@Test
	public void test1()throws Exception{
		MailDomain mail=new MailDomain("test@zzMail.com","test123","<test@zzMail.com>","<Ted@zzMail.com>","test","test with file");
		String path="src/test/java/test.jpg";
		mail.setFile(path);
		SendMail send=new SendMail(mail);
		send.send();
	}
}
