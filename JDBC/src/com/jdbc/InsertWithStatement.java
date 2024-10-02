package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertWithStatement {
	
	public static void main(String[] args) throws Exception{
//		Loading the Driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
//		Establish the Connection
		
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "Admin";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		if(conn != null) {
			
			System.out.println("Connected");
		}
		
		//Get the Statement Object
		
		Statement st = conn.createStatement();
		
//		Pass Sql query
		st.executeUpdate("insert into employee values(102,'Manish',63746)");
	}

}
