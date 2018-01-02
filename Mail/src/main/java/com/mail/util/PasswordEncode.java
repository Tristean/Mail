package com.mail.util;

import java.security.MessageDigest;

public class PasswordEncode {
	private final static String[]digits={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	public static String encode(String password) throws Exception{
		if(password==""||password==null){
			return null;
		}
		MessageDigest sha=MessageDigest.getInstance("SHA");
		sha.update(password.getBytes());
		byte[]bytes=sha.digest();
		return byteToHexString(bytes);
	}
	public static String byteToHexString(byte b){
		int ret=b;
		if(ret<0){
			ret+=256;
		}
		int m=ret/16;
		int n=ret%16;
		return digits[m]+digits[n];
	}
	
	public static String byteToHexString(byte[]bytes){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<bytes.length;i++){
			sb.append(byteToHexString(bytes[i]));
		}
		return sb.toString();
	}
}
