package com.jdbc.sep;
import java.sql.*; 
import java.sql.DriverManager;

public class JdbcDaoGet {
	
	public static void main(String[] args) {
		PiratesDAO dao = new PiratesDAO();
		Pirates s1 = dao.getPirates(3);
		System.out.println(s1.name);
	}
	
	static class PiratesDAO{
		public Pirates getPirates(int rollno) {
			
			try {
				String query = "select name from pirates where id ="+rollno;
				Pirates s = new Pirates();
				s.id = rollno;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoro", "root", "roshini$m");
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
	}
	
	static class Pirates {
		int id;
		String name;
	}

}
