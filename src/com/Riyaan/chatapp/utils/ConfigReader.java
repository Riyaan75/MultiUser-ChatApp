package com.Riyaan.chatapp.utils;

import java.util.ResourceBundle;

public class ConfigReader {
	//default constructor so that nobody can access it from outside
	ConfigReader(){}
//	private static final String ResourceBoundle = null;
	private static ResourceBundle rb= ResourceBundle.getBundle("configuration");
	//function that will read data
	public static String getValue(String key) {
		return rb.getString(key);
	}
	

}
