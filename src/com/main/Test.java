package com.main;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import com.jdbc.DBConnect;

public class Test {

	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("in class test");
		Connection connection = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		String name = null;
		int age = -1;
		String company = null;
		String room = null;
		
		try{
			
			System.out.println("connection call from test");
			
			//database connection setup
			connection = DBConnect.getConnection();
			System.out.println("creating statemnet");
			stmt = connection.createStatement();
			
			//create table 
			String createQuery = "Create table flatmates ("
					+ "name varchar(20),"
					+ "age int,"
					+ "room varchar(20),"
					+ "company varchar(20)"
					+ ");";
			
			stmt.executeUpdate(createQuery);
			System.out.println("table created");
			//insert data into table flatmates
			System.out.println("enter total no of members : ");
			
			int totalMember = sc.nextInt();
			sc.nextLine();
			for(int i=1;i<=totalMember;i++){
				
				System.out.println("enter details of member 1");
				System.out.print("name : ");
				name = sc.nextLine();
				//sc.nextLine();
				System.out.print("age : ");
				age = sc.nextInt();
				sc.nextLine();
				System.out.print("room : ");
				room = sc.nextLine();
				//sc.nextLine();
				System.out.print("comapny : ");
				company =  sc.nextLine();
				//sc.nextLine();
				
				String insertQuery = "insert into flatmates values('"+name+"','"+age+"','"+room+"','"+company+"')";
				stmt.executeUpdate(insertQuery);
			}
			
			String query =  "select * from flatmates";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println();
			System.out.println("Here are your Results : ");
			System.out.println();
			while(rs.next()){
				
				name = rs.getString("name");
				age = rs.getInt("age");
				room = rs.getString("room");
				company  = rs.getString("company");
				System.out.println("1. name = "+name+"   age= "+age+"   room = "+room+"    company = "+company);
			}
			
		}
		catch(Exception e){
			System.out.println("exception in test class while executing query");
			System.out.println(e);
			e.printStackTrace();
		}
		finally{
			stmt.close();
			connection.close();
			sc.close();
		}
	}
}
