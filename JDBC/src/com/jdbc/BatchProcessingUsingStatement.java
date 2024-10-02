package com.jdbc;

import java.sql.*;

public class BatchProcessingUsingStatement {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "Admin";
		
		Connection conn = DriverManager.getConnection(url,user,password);
		
		Statement st  = conn.createStatement();
		st.addBatch("create table faculty(id int(3), name varchar(50), salary int(6), desg varchar(50), qua varchar(50))");
		
		st.addBatch("insert into faculty values(101, 'Anand', 45000, 'Asst.prof', 'M.Tech')");
		st.addBatch("insert into faculty values(102, 'Manish', 55000, 'Prof', 'B.Tech')");
		st.addBatch("insert into faculty values(103, 'Satya', 65000, 'Asoc.prof', 'Phd')");
		st.addBatch("insert into faculty values(104, 'Samar', 75000, 'Asst.prof', 'BSc')");
		st.addBatch("insert into faculty values(105, 'Sangram', 85000, 'Asst.prof', 'B.com')");
		
		st.executeBatch();

	}

}
