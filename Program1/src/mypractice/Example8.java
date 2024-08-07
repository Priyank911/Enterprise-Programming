package mypractice;

import java.sql.*;

public class Example8 {
	public static void main (String[] args) {
	  Connection conn=null;
	  try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    conn=DriverManager.getConnection(
	        "jdbc:mysql://localhost:3306/classicmodels?useSSL=false"
	        ,"root","P@&&word0911");
	    Statement stmt=conn.createStatement();
	    String SQL="insert into empmost values(100,'Priyank','Panchal','987898789',"
	        + "'developer@google.com','Programmer',10)";
	    int rowaffected=stmt.executeUpdate(SQL);
	    if(rowaffected>0) {
	      System.out.println("Record inserted successfully!");
	      
	    }
	    else {
	      System.out.println("Error in insert!");
	    }
	    conn.close();
	  }
	  catch(Exception e) {
	    System.out.println("Error :" +e.getMessage());
	  }
	}
}
