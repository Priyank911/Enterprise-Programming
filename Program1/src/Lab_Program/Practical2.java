package Lab_Program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Practical2 {
    public static void main(String... args) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/classicmodels?useSSL=false";
            con = DriverManager.getConnection(connectionUrl, "root", "P@&&word0911");
            

            PreparedStatement pstmt = con.prepareStatement("insert into div3stud values(?,?,?)");
            pstmt.setInt(1, 4);
            pstmt.setString(2, "Kevin");
            pstmt.setString(3, "8785875548");
            pstmt.executeUpdate(); 
            

            pstmt = con.prepareStatement("SELECT StdId, Name, Mobno from div3stud");
            ResultSet result = pstmt.executeQuery();
            
            ResultSetMetaData rsmd = result.getMetaData();
            System.out.println("Total columns: " + rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
            System.out.println("Column Name of 2nd column: " + rsmd.getColumnName(2));
            System.out.println("Column Name of 3rd column: " + rsmd.getColumnName(3));
            System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));
            System.out.println("Column Type Name of 2nd column: " + rsmd.getColumnTypeName(2));
            System.out.println("Column Type Name of 3rd column: " + rsmd.getColumnTypeName(3));
            
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
