package com.servlet.connector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/servlet3")
public class servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servlet3() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        PrintWriter pw = response.getWriter();
        pw.write("<html>");
        pw.write("<body>");
        pw.write("<p>Name :- "+name+"</p>");
        pw.write("<p>DOB :- "+dob+"</p>");
        pw.write("<p>Email :- "+email+"</p>");
        pw.write("<p>Phone :- "+phone+"</p>");
        pw.write("</body>");
        pw.write("</html>");
    }

}
