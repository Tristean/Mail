package com.mail.service.mail;

public class MailConstant {
	//收件夹
	public static final String FOLDER_INBOX="INBOX";
	//已发送
	public static final String FOLDER_SEND="SENDED";
	//草稿
	public static final String FOLDER_DRAFT="DRAFT";
	//已删除
	public static final String FOLDER_DELETE="DELETE";
	//垃圾邮件
	public static final String FOLDER_TRASH="TRASH";
	
	//邮件类型
	public static final int INBOX=1;
	public static final int DRAFT=2;
	public static final int SENDED=3;
	public static final int DELETE=4;
	public static final int TRASH=5;
	
	public static final int MAXRESULT=10;
	public static final int PAGE_COUNT=8;
	public static final String EMAIL_CONFIG_PATH="mail.properties";
}
