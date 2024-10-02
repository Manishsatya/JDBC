package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteById {

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
		
		String query = "delete from student where id=?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		System.out.println("Enter Id to delete");
		ps.setInt(1, sc.nextInt());
		ps.executeUpdate();
		
		conn.close();

	}

}
