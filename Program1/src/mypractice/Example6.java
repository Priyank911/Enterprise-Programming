package mypractice;

import java.sql.*;


public class Example6 {
	public static void main(String[] args) {
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","P@&&word0911");
		
		PreparedStatement pstmt = con.prepareStatement("insert into div3stud values(?,?,?)");
		pstmt.setInt(1,2);
		pstmt.setString(2,"Shrey");
		pstmt.setString(3,"9638947938");
		
		int rowAffected = pstmt.executeUpdate();
		if(rowAffected > 0)
			System.out.print("Data Inserted Successfully");
	}
		catch(Exception ex) {
			System.out.print("Error: "+ ex.getMessage());
	}
}
}
