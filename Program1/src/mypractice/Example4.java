package mypractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Example4 {
	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","P@&&word0911");
			Statement stmt = con.createStatement(); 
			String SQL = "delete from div3stud where StdID='2'";
			int rowseffected = stmt.executeUpdate(SQL);
			if(rowseffected > 0) 
				System.out.println("Record inserted succcessfully!");

		}catch(Exception ex) {
			System.out.print("Error: "+ ex.getMessage());
		}
	}
}
