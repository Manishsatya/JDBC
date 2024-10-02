package com.jdbc;

import java.sql.*;

public class GetConnection {

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
		

	}

}
