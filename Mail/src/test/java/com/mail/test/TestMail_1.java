package com.mail.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestMail_1 {
	public static void main(String[]args){
		String to="1256317763@qq.com";
		String from="861907286@qq.com";
		String host="localhost";
		
		Properties properties=System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		
		Session session=Session.getDefaultInstance(properties);
		
		try{
			MimeMessage message=new MimeMessage(session);
			
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("test");
			message.setText("test text");
			
			Transport.send(message);
			System.out.println("send");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
