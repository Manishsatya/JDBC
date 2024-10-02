package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class GetResultsWithCondition {

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
		
		Scanner sc =  new Scanner(System.in);
		String query = "select * from student where age >= ?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, sc.nextInt());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.print(rs.getInt(1)+"     ");
			System.out.print(rs.getString(2)+"     ");
			System.out.print(rs.getInt(3)+"     ");
			System.out.println();
		}
		conn.close();
	}

}
