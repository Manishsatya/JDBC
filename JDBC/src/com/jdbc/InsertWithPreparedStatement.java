package com.jdbc;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertWithPreparedStatement {
	
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
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id : Int");
		int id = sc.nextInt();
		
		System.out.println("Enter Name : String");
		String name = sc.next();
		
		System.out.println("Enter age : Int");
		int age = sc.nextInt();
		
		//Get the Prepared Statement Object
		
		String query = "insert into student values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		
		ps.executeUpdate();
		
		conn.close();
	}

}
