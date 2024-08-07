package mypractice;

import java.util.*;
import java.sql.*;

public class Example7 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int opernEnter;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false", "root", "P@&&word0911");
                 Statement stmt = con.createStatement();
                
                while (true) {
                    System.out.println("Choice Operation:- \n" 
                            + "1-> Insert in table \n"
                            + "2-> Update in table \n"
                            + "3-> delete in table \n"
                            + "4-> Show Data \n"
                            + "5-> Exit");
                    System.out.print("Enter the Choice for Operation:- ");

                    while (!sc.hasNextInt()) {
                        System.out.print("Bro Enter a Valid Number: ");
                        sc.next();
                    }
                    opernEnter = sc.nextInt();
                    sc.nextLine();

                    if (opernEnter == 5) {
                        System.out.println("Choose 5: exit");
                        break;
                    }

                    switch (opernEnter) {
                        case 1:
                            insertMethod(stmt, sc);
                            break;
                        case 2:
                            updateMethod(stmt, sc);
                            break;
                        case 3:
                            deleteMethod(stmt, sc);
                            break;
                        case 4:
                            showMethod(stmt);
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
        } catch (Exception ex) {
            System.out.print("Error arise:- " + ex.getMessage());
        } finally {
            sc.close();
        }
    }

    private static void insertMethod(Statement stmt, Scanner sc) throws SQLException {
        System.out.print("So now you have entered the Insert Method: \n \n"
            + "Enter the Required Data\n \n");

        System.out.print("Enter Student ID: ");
        int StdId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String Name = sc.nextLine();

        System.out.print("Enter Mobile Number: ");
        String Mobno = sc.nextLine();

        String SQL = "insert into div3stud values(" + StdId + ",'" + Name + "','" + Mobno + "')";
        int rowsAffected = stmt.executeUpdate(SQL);
        if (rowsAffected > 0)
            System.out.println("Record inserted successfully!");
    }

    private static void updateMethod(Statement stmt, Scanner sc) throws SQLException {
        System.out.print("So now you have entered the Update method: \n"
            + "Enter the details for the update \n");

        System.out.print("Enter the ID where you want to update: ");
        int StdId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the Mobile number for update: ");
        String Mobno = sc.nextLine();

        String SQL = "update div3stud set Mobno='" + Mobno + "' where StdId=" + StdId;
        int rowsAffected = stmt.executeUpdate(SQL);
        if (rowsAffected > 0)
            System.out.println("Record updated successfully!");
    }

    private static void deleteMethod(Statement stmt, Scanner sc) throws SQLException {
        System.out.print("So now you have entered the Delete method: \n"
            + "Enter the detail for the delete \n");

        System.out.print("Enter the ID where you want delete: ");
        int StdId = sc.nextInt();
        sc.nextLine();

        String SQL = "delete from div3stud where StdID=" + StdId;
        int rowsAffected = stmt.executeUpdate(SQL);
        if (rowsAffected > 0)
            System.out.println("Record deleted successfully!");
    }

    private static void showMethod(Statement stmt) throws SQLException {
        System.out.println("So now you have entered the Show Data method: \n");

        System.out.println("Here is Your Data: \n");
        ResultSet res = stmt.executeQuery("SELECT * FROM div3Stud");
        try {
            while (res.next()) {
                System.out.println(res.getInt("StdId") + "\t \t \t" + 
                                   res.getString("Name") + "\t \t \t" + 
                                   res.getString("Mobno")+"\n");
            }
        } finally {
            res.close();
        }
    }
}
