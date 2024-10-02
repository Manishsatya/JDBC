package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CreateTable {

		
		public static void main(String[] args) throws Exception{
//			Loading the Driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Establish the Connection
			
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "Admin";
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			if(conn != null) {
				
				System.out.println("Connected");
			}
//			Get the statement object
			
//			Statement st = conn.createStatement();
			
			String query = "create table student(id int(3),name varchar(50), age int(3))";
			PreparedStatement ps = conn.prepareStatement(query);
			
//			Pass Sql query to the DB
			
//			st.executeUpdate("create table Employee(id int(3), name varchar(50), salary int(6))");
			
			ps.executeUpdate();
			
			
			

	}

}
