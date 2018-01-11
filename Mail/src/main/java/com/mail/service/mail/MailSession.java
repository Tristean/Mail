package com.mail.service.mail;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.mail.Session;

import com.mail.domain.MailDomain;
import com.mail.service.mail.send.SendMail;

public class MailSession {
	public static Session createSession(String name,SmtpAuth auth){
		Session session=null;
		Properties props=MailSession.getProperties(name);
		session=Session.getInstance(props,auth);
		return session;
	}
	public static Session createSession(){
		Session session=null;
		Properties props=MailSession.setProperties();
		session=Session.getDefaultInstance(props);
		return session;
	}
	
	public static Properties getProperties(String name){
		Properties props=null;
		InputStream is=null;
		try{
			is=MailSession.class.getResourceAsStream(name);
			props=new Properties();
			props.load(is);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(is!=null)
					is.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return props;
	}
	
	public static Properties setProperties(){
		Properties props=new Properties();
		
		props.setProperty("mail.debug", "true");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.host", "120.78.198.157");
		props.setProperty("mail.smtp.port", "25");
		props.setProperty("mail.pop3.port", "110");
		return props;
	}
	
	public static Session getInstance(String name){
		return Session.getInstance(getProperties(name));
	}
	
}
