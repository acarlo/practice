package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.DBConnect;


public class PreparedStatementPrac {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			
			connection = DBConnect.getConnection();
			
			//table creation ----->
			System.out.println("creating table");
			String createQuery = "create table if not exists employee("
					+ "name varchar(20),"
					+ "age int,"
					+ "company varchar(20),"
					+ "id int);";
			pstmt = connection.prepareStatement(createQuery);
			pstmt.executeUpdate();
			
			//data insertion ----->
			System.out.println("inserting data");
			String insertQuery = "insert into employee values(?,?,?,?);";
			pstmt = connection.prepareStatement(insertQuery);
			for(int i=0;i<5;i++){
				pstmt.setString(1, "employee "+i);
				pstmt.setInt(2, 20+i);
				pstmt.setString(3, "company "+i);
				pstmt.setInt(4, 1000+i);
				pstmt.executeUpdate();
			}
			
			
			//data update ----->
			System.out.println("updating data");
			String updateQuery = "update employee set age=?,id=? where name=?;";
			pstmt = connection.prepareStatement(updateQuery);
			pstmt.setInt(1, 30);
			pstmt.setInt(2, 1050);
			pstmt.setString(3, "employee 1");
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			System.out.println("exception in preparedstatemnt class");
			System.out.println(e);
			e.printStackTrace();
		}
		finally{
			pstmt.close();
			connection.close();
		}
	}
}
