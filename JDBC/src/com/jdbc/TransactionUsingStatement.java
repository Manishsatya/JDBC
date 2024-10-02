package com.jdbc;

import java.sql.*;
import java.util.*;

public class TransactionUsingStatement {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pass = "Admin";
		
		Scanner sc = new Scanner(System.in);
		Connection conn = DriverManager.getConnection(url,user,pass);
		conn.setAutoCommit(false);
		Statement st =conn.createStatement();
		st.executeUpdate("insert into faculty values(112, 'ABC', 75000, 'Prof', 'Phd')");
		
		
		
		System.out.println("Commit: C, Rollback: R");
		String str = sc.next();
		if(str.equals("R")) {
			conn.rollback();
		}
		else if(str.equals("C")) {
			conn.commit();
		}
		conn.close();
		sc.close();

	}

}
