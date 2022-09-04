package com.Riyaan.chatapp.dao;

import java.sql.Connection;
// throw early and catch later is good practice
import java.sql.DriverManager;
import java.sql.SQLException;
//connecting files through each other
import static com.Riyaan.chatapp.utils.ConfigReader.getValue;
public interface CommonDAO {
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		//step 1 load a driver
		Class.forName(getValue("DRIVER"));
		//step 2Making a Connection
		final String CONNECTION_STRING = getValue("CONNECTION_URL");
		final String USER_ID = getValue("USERID");
//		final String EMAIL = getValue("EMAIL");
//		final String PHONENO = getValue("PHONENO");
//		final String ADDRESS = getValue("ADDRESS");
		final String PASSWORD = getValue("PASSWORD");
		//Connection con= DriverManager.getConnection(CONNECTION_STRING, USER_ID ,EMAIL,PHONENO,ADDRESS,PASSWORD);
		Connection con= DriverManager.getConnection(CONNECTION_STRING, USER_ID  ,PASSWORD);
		if(con != null) {
			System.out.println("Connection Created..");
			//con.close();
		}
		return con;
		 
	}
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		CommonDAO commonDAO = new CommonDAO();
//		commonDAO.createConnection();
//	}
}
