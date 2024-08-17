package com.jdbc;
import java.sql.*; // 1st step

public class JdbcConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Class.for name video in telusko
		String url = "jdbc:mysql://localhost:3306/zoro"; 
		String username = "root";
		String password = "roshini$m";
		String query = "select name from pirates where id=2";
		
		Class.forName("com.mysql.cj.jdbc.Driver"); //2nd step
		Connection con = DriverManager.getConnection(url, username, password); // 3rd step
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next(); // its by defalt point at the colunm naame we've to manually move the pointer to down.
		String name = rs.getNString("name");
		System.out.println(name);
		
		st.close();
		rs.close();
		
		
		
	}

}
