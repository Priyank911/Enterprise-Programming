package Lab_Program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Practical1 {
	public static void main(String... args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?allowPublicKeyRetrieval=true&useSSL=false","root","P@&&word0911");
			Statement stmt = con.createStatement(); 
			String SQL = "insert into div3stud values(3,'Prayers','9854785687')";
			int rowseffected = stmt.executeUpdate(SQL);
			if(rowseffected > 0) { 
				System.out.println("Record inserted succcessfully!");
			}
			System.out.println("Here is Data : \n");
			
			ResultSet res = stmt.executeQuery("Select * from div3stud");
			 while (res.next()) {
	                System.out.println(res.getInt("StdId") + "\t" + 
	                                   res.getString("Name") + "\t" + 
	                                   res.getString("Mobno")+"\n");
	            }
			con.close();

		}catch(Exception ex) {
			System.out.print("Error: "+ ex.getMessage());
		}
	}
}
