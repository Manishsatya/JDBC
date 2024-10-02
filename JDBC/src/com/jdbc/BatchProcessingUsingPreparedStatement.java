package com.jdbc;

import java.sql.*;

public class BatchProcessingUsingPreparedStatement {
	
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "Admin";
		
		Connection conn = DriverManager.getConnection(url,user,password);
		
		String query = "create table Customer(id int(3), name varchar(50), city varchar(50), dob varchar(50))";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.addBatch();
		ps.addBatch("insert into customer values(101,'Manish', 'Vijayawada', '18/11/2000')");
		ps.addBatch("insert into customer values(102,'Satya', 'Hyd', '07/07/1972')");
		ps.addBatch("insert into customer values(103,'Samar', 'Sec', '01/08/1998')");
		ps.addBatch("insert into customer values(104,'Lekhana', 'Guntur', '26/12/1992')");
		ps.addBatch("insert into customer values(105,'Pandu', 'Tenali', '01/11/1991')");
		
		ps.executeBatch();
		}
		
}
