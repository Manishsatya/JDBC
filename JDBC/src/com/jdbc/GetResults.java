package com.jdbc;

import java.sql.*;

public class GetResults {

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
		
		String query = "select * from student";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.print(rs.getInt(1)+"     ");
			System.out.print(rs.getString(2)+"     ");
			System.out.print(rs.getInt(3)+"     ");
			System.out.println();
		}
	}

}
