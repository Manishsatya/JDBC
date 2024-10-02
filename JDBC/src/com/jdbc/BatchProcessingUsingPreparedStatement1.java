package com.jdbc;

import java.sql.*;
import java.util.Scanner;


public class BatchProcessingUsingPreparedStatement1 {

		public static void main(String[] args) throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "Admin";
			
			Connection conn = DriverManager.getConnection(url,user,password);
			
			String query = "insert into customer values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			Scanner sc = new Scanner(System.in);
			while(true) {
				
				System.out.println("Enter Id");
				ps.setInt(1, sc.nextInt());
				System.out.println("Enter Name");
				ps.setString(2, sc.next());
				System.out.println("Enter City");
				ps.setString(3, sc.next());
				System.out.println("Enter DOB");
				ps.setString(4, sc.next());
				
				ps.addBatch();
				
				System.out.println("Do you want to Insert One more record? : Y/N");
				
				if(sc.next().equals("N")) {
					break;
				}
			}
			ps.executeBatch();
			
			conn.close();
			

	}

}
