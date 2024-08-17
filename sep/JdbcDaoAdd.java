package com.jdbc.sep;
import java.sql.*;
public class JdbcDaoAdd {
	public static void main(String[] args) {	
		PiratesDAO dao = new PiratesDAO();
		Pirates s2 = new Pirates();
		s2.id = 10;
		s2.name = "Franky";
		dao.connect();
		dao.addPirates(s2);
	}
	
	static class PiratesDAO{
		Connection con = null;
		
		public void connect(){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoro", "root", "roshini$m");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
		public Pirates getPirates(int rollno) {
			try {
				String query = "select name from pirates where id ="+rollno;
				Pirates s = new Pirates();
				s.id = rollno;
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				rs.next();
				String name1 = rs.getString(1);
				s.name = name1;
				return s;
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
			
		}
		
		public void addPirates(Pirates p) {
			String query = "insert into Pirates values (?, ?)";
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(query);
				pst.setInt(1, p.id);
				pst.setString(2, p.name);
				pst.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	static class Pirates {
		int id;
		String name;	
	}
}
