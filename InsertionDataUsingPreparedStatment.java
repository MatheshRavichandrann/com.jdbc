package com.jdbc;
import java.sql.*;
public class InsertionDataUsingPreparedStatment {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/zoro";
		String usrname = "root";
		String pass = "roshini$m";
		int id = 5;
		String name = "sanji";
		String query = "insert into pirates values (?, ?)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, usrname, pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, id);
		st.setString(2, name);
		int count = st.executeUpdate();
		System.out.println(count + "Row/s affected");
		
		st.close();
		con.close();
		}

}
