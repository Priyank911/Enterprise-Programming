package com.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/RegisServlet")
public class RegisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.setContentType("text/html"); 
//		PrintWriter out = response.getWriter();
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		out.print("UserName: "+username);
//		out.print("Password: "+password);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 PreparedStatement pstmt = null;
			 PrintWriter pw = response.getWriter();
			  String username = request.getParameter("username");
		        String password = request.getParameter("password");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","P@&&word0911");
		    Statement st = con.createStatement();
		    String query = "INSERT INTO Users (username, password) VALUES (?, ?)";
		    pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                pw.print("<h2>Registration successful!</h2>");
            } else {
            	pw.print("<h2>Registration failed!</h2>");
            }
		}catch (ClassNotFoundException | SQLException e) {
            System.out.println("<h2>An error occurred: " + e.getMessage() + "</h2>");
            e.printStackTrace();
        }
	}

}
