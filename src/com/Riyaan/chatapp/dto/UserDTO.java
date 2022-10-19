package com.Riyaan.chatapp.dto;

public class UserDTO {
	private String userid;
	private String email;
	private String phoneno;
	private String city;
	private char[] password;
	public UserDTO(String userid, char[] password,String email,String phoneno,String city ) {
	//public UserDTO(String userid, char[] password) {
		this.userid = userid;
		this.email = email;
		this.phoneno = phoneno;
		this.city = city;
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return city;
	}
	public void setAddress(String address) {
		this.city = address;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}

}
