package com.Riyaan.chatapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Riyaan.chatapp.dto.UserDTO;
import com.Riyaan.chatapp.utils.Encryption;

//USER CRUD 
public class UserDAO {
	
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException, Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		final String SQL = "Select userid from users where userid=? and password=?";
		try {
			con= CommonDAO.createConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, userDTO.getUserid());
			String encryptedPas=Encryption.passwordEncrypt(new String(userDTO.getPassword()));
			pstmt.setString(2, encryptedPas);
			rs=pstmt.executeQuery();
			return rs.next();
//			if(rs.next()) {
//				return true;
//			}
//			else {
//				return false;
//			}
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	
	//public int add(String userid, String password, byte age, String city, String phone , String email, String country, String state, String areaCode, String stdCode){
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, Exception {	
//		System.out.println("Rec "+userDTO.getUserid()+" "+userDTO.getEmail()+" "+userDTO.getPhoneno()+" "+userDTO.getAddress()+" "+userDTO.getPassword());
		System.out.println("Rec "+userDTO.getUserid()+" "+userDTO.getPassword());
		Connection connection = null;
		Statement stmt = null; // query
		try { // Guarded region
		connection = CommonDAO.createConnection(); // Step-1 Connection Create
		// Step-2 We do a Query
		stmt = connection.createStatement();
		// insert into users (userid, password) values('ram','ram123');
		//int record = stmt.executeUpdate("insert into users (userid,email,phoneno,address, password) values('"+userDTO.getUserid()+"','"+userDTO.getEmail()+"','"+userDTO.getPhoneno()+"','"+userDTO.getAddress()+"','"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"')"); // Insert, Delete, Update
		int record = stmt.executeUpdate("insert into users (userid, password) values('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"')"); // Insert, Delete, Update
		return record;
		}
		finally { // Always execute (Resource Clean)
			if(stmt!=null) {
		stmt.close();
			}
			if(connection!=null) {
		connection.close();
			}
		}
	
		
	}

}
