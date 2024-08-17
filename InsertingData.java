package com.jdbc;
import java.sql.*;
public class InsertingData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/zoro"; 
		String username = "root";
		String password = "roshini$m";
		String query = "insert into pirates values(4, 'zoro')";
		
		Class.forName("com.mysql.cj.jdbc.Driver"); //2nd step
		Connection con = DriverManager.getConnection(url, username, password); // 3rd step
		Statement st = con.createStatement();
		int count= st.executeUpdate(query);
		
		System.out.println(count + "Row/s affected");
		
		st.close();
		con.close();
	}

}
