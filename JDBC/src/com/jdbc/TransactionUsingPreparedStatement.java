package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TransactionUsingPreparedStatement {

		public static void main(String[] args) throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "Admin";
			
			Connection conn = DriverManager.getConnection(url,user,password);
			conn.setAutoCommit(false);
			String query = "insert into faculty values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			
			Scanner sc = new Scanner(System.in);
			while(true) {
				
				System.out.println("Enter Id");
				ps.setInt(1, sc.nextInt());
				System.out.println("Enter Name");
				ps.setString(2, sc.next());
				System.out.println("Enter Salary");
				ps.setInt(3, sc.nextInt());
				System.out.println("Enter Designation");
				ps.setString(4, sc.next());
				System.out.println("Enter Qualification");
				ps.setString(5, sc.next());
				
				ps.executeUpdate();
				
				System.out.println("Commit: C, Rollback: R");
				String str = sc.next();
				if(str.equals("R")) {
					conn.rollback();
				}
				else if(str.equals("C")) {
					conn.commit();
				}
				
				System.out.println("Do you want to Insert One more record? : Y/N");
				str=sc.next();
				if(str.equals("N")) {
					break;
				}
				
				
			}
			conn.close();

	}

}
