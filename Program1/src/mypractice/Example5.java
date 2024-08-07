package mypractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Example5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Std ID:- ");
		int StdID = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter the Name:- ");
		String Name = sc.nextLine();
		sc.nextLine();
		
		System.out.print("Enter the Mobile no:- ");
		String Mobno = sc.nextLine();
		
		sc.close();
	
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","P@&&word0911");
			Statement stmt = con.createStatement(); 
			String SQL = "insert into div3stud values("+StdID+",'" + Name + "','" + Mobno + "')";
			int rowseffected = stmt.executeUpdate(SQL);
			if(rowseffected > 0) 
				System.out.println("Record inserted succcessfully!");

		}catch(Exception ex) {
			System.out.print("Error: "+ ex.getMessage());
		}
	}

}
