package mypractice;
import java.sql.*;

public class Example1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","P@&&word0911");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("Select * from emp");
			while(res.next()) {
				System.out.println(res.getInt(1) + "\t" + 
						res.getString("ename") + "\t" + 
						res.getDate("hiredate"));
			}
			con.close();
		}
		catch(Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
}
