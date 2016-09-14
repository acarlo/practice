package com.jdbc;

import java.sql.*;

public class DBConnect {

	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/TEST";
	   static final String USER = "root";
	   static final String PASS = "root";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Connection connection = null;
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("connecting to Database");
		connection = DriverManager.getConnection(DB_URL,USER,PASS);
		}
		catch(Exception e){
			System.out.println("excetion in databse connection");
			System.out.println(e);
		}
		return connection;
		
	}
	
}
