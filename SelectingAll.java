package com.jdbc;
import java.sql.*;

public class SelectingAll {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/zoro"; 
		String username = "root";
		String password = "roshini$m";
		String query = "select * from pirates";
		
		Class.forName("com.mysql.cj.jdbc.Driver"); //2nd step
		Connection con = DriverManager.getConnection(url, username, password); // 3rd step
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		String userData;
		
//		rs.next(); // its by defalt point at the colunm naame we've to manually move the pointer to down.
//		userData = rs.getInt(1) + " : " + rs.getString(2);
//		System.out.println(userData);
//		
//		rs.next(); // its by defalt point at the colunm naame we've to manually move the pointer to down.
//		userData = rs.getInt(1) + " : " + rs.getString(2);
//		System.out.println(userData);
//		
//		rs.next(); // its by defalt point at the colunm naame we've to manually move the pointer to down.
//		userData = rs.getInt(1) + " : " + rs.getString(2);
//		System.out.println(userData); 
		
		
		// Instead of wrting this multiple time, we can use a simple while loop.
		
		
		while(rs.next()) { // itll check and move the pointer down. if there is no row is down it'll give false and end the loop.
		userData = rs.getInt(1) + " : " + rs.getString(2);
		System.out.println(userData);
		}
		
		
		st.close();
		rs.close();
	}

}
