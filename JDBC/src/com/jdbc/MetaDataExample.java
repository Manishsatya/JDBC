package com.jdbc;

import java.sql.*;

public class MetaDataExample {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "Admin";
		
		Connection conn = DriverManager.getConnection(url,user,password);
		
		String query = "select * from product";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		ResultSetMetaData metadata = rs.getMetaData();
		
		System.out.println("Column count : "+metadata.getColumnCount());
		for(int i =1; i<9;i++) {
			System.out.println(i+" Column name : "+metadata.getColumnName(i)+" : "+metadata.getColumnTypeName(i));
		}
		

	}

}
