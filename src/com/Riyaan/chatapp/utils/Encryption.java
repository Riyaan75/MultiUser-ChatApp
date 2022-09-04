package com.Riyaan.chatapp.utils;
 // md5 hashing is used therefore no password is shown to developer

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
	
	public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException{
		String encryptedPassword = null;
		//it is a pre build class for securing password
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(plainPassword.getBytes());
		byte [] encrypt = messageDigest.digest();
		System.out.println(encrypt);
		//we use SB because it is utable and don't create memory again and again
		StringBuffer sb = new StringBuffer();
		for(byte b : encrypt) {
			sb.append(b);
		}
		encryptedPassword  = sb.toString();
		//System.out.println("Encrypted password "+encryptedPassword);
		
		return encryptedPassword;
	}
	
}
