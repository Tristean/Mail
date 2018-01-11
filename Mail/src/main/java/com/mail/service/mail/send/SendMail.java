package com.mail.service.mail.send;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.mail.domain.MailDomain;
import com.mail.service.mail.MailConstant;
import com.mail.service.mail.MailSession;

public class SendMail {
	private MailDomain  mail=null;
	private Session session=null;
	
	public SendMail(MailDomain mail){
		this.mail=mail;
	}
	
	//创建邮件
	public MimeMessage createMimeMessage()throws Exception{
		session=MailSession.createSession(MailConstant.EMAIL_CONFIG_PATH, mail.getAuth());
		
		MimeMessage message=new MimeMessage(session);
		setMimeMessageInfo(message);
		MimeMultipart multipart=null;
		
		if(mail.getContent()!=null&&mail.getContent().length()>0)
			multipart=createAlternative(multipart);
		if(mail.getResource()!=null&&mail.getResource().length()>0)
			multipart=createRelated(multipart);
		if(mail.getFile()!=null&&mail.getFile().length()>0)
			multipart=createMixed(multipart);
		if(multipart==null)
			multipart=createAlternative(multipart);
		message.setContent(multipart);
		message.saveChanges();
		return message;
	}
	
	
	//设置邮件信息
	private void setMimeMessageInfo(MimeMessage message)throws Exception{
		if(mail.getFrom()!=null&&!"".equals(mail.getFrom())){
			message.setFrom(new InternetAddress(encode(mail.getFrom())));
			message.setSender(new InternetAddress(encode(mail.getFrom())));
		}
		if(mail.getTo()!=null&&!"".equals(mail.getTo()))
			message.setRecipients(RecipientType.TO, InternetAddress.parse(encode(mail.getTo())));
		if(mail.getCc()!=null&&!"".equals(mail.getCc()))
			message.setRecipients(RecipientType.CC, InternetAddress.parse(encode(mail.getCc())));
		if(mail.getBcc()!=null&&!"".equals(mail.getBcc()))
			message.setRecipients(RecipientType.BCC, InternetAddress.parse(encode(mail.getBcc())));
		if(mail.getSubject()!=null&&!"".equals(mail.getSubject()))
			message.setSubject(mail.getSubject(),"UTF-8");
		if(mail.isExigence()){
			message.setHeader("X-Priority", "1");
		}else{
			message.setHeader("X-Priority", "3");
		}
			
	}
	private String encode(String info)throws Exception{
		Pattern p=Pattern.compile("(\"(.*?)\" ?<)");
		StringBuffer sb=new StringBuffer();
		Matcher matcher=p.matcher(info);
		while(matcher.find()){
			matcher.appendReplacement(sb, MimeUtility.encodeText(matcher.group(2),"UTF-8","B")+"<");
		}
		matcher.appendTail(sb);
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	//创建邮件体
	private MimeMultipart createMixed(MimeMultipart multipart) throws MessagingException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		MimeBodyPart related=new MimeBodyPart();
		if(multipart==null)
			multipart=createAlternative(multipart);
		related.setContent(multipart);
		MimeMultipart mixed=new MimeMultipart("mixed");
		mixed.addBodyPart(related);
		mixed=addAttachment(mixed);
		return mixed;
	}
	private MimeMultipart addAttachment(MimeMultipart mixed) throws MessagingException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String[]files=mail.getFile().split(",");
		for(String file:files){
			System.out.println(file);
			MimeBodyPart attachment=new MimeBodyPart();
			FileDataSource fds=new FileDataSource(file);
			attachment.setDataHandler(new DataHandler(fds));
			attachment.setFileName(MimeUtility.encodeText(fds.getName(),"UTF-8","Q"));
			System.out.println("add file success");
			mixed.addBodyPart(attachment);
		}
		return mixed;
	}

	private MimeMultipart createRelated(MimeMultipart multipart) throws MessagingException {
		// TODO Auto-generated method stub
		MimeBodyPart alternative=new MimeBodyPart();
		alternative.setContent(multipart);
		MimeMultipart related=new MimeMultipart("related");
		related.addBodyPart(alternative);
		related=addResource(related);
		return related;
	}
	private MimeMultipart addResource(MimeMultipart related) throws MessagingException {
		// TODO Auto-generated method stub
		String[]resources=mail.getResource().split(",");
		for(String res:resources){
			MimeBodyPart img=new MimeBodyPart();
			FileDataSource fds=new FileDataSource(res);
			img.setDataHandler(new DataHandler(fds));
			img.setContentID(System.currentTimeMillis()+fds.getName());
			related.addBodyPart(img);
		}
		return related;
	}
	private MimeMultipart createAlternative(MimeMultipart multipart) throws MessagingException {
		// TODO Auto-generated method stub
		multipart=new MimeMultipart("alternative");
		MimeBodyPart html=new MimeBodyPart();
		html.setContent(mail.getContent(),"text/html;charset=UTF-8");
		multipart.addBodyPart(html);
		return multipart;
	}
	
	
	//发邮件
	public void send(MimeMessage message) throws MessagingException{
		Transport.send(message);
	}
	
	public void send(MailDomain mail) throws Exception{
		MimeMessage message=createMimeMessage();
		Transport transport=session.getTransport();
		transport.connect(mail.getUsername(), mail.getPassword());
		transport.sendMessage(message,new Address[]{new InternetAddress("Ted@zzMail.com")} );
	}
	public void send() throws Exception{
		MimeMessage message=createMimeMessage();
		Transport.send(message);
	}
	
}
