package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateAge {

public static void main(String[] args) throws Exception{
		
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
		
		String query = "update student set age= ?,name= ? where id= ?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		System.out.println("Enter Age to Update : Int");
		ps.setInt(1, sc.nextInt());
		
		System.out.println("Enter Name to Update : String");
		ps.setString(2, sc.next());
		
		System.out.println("Enter id for update Age and Name");
		ps.setInt(3, sc.nextInt());
		
		ps.executeUpdate();
		
		conn.close();

	}

}
