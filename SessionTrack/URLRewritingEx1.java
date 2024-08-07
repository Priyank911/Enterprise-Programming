package com.practices.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/URLRewritingEx1")
public class URLRewritingEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
				
		pw.print("<html><body>");

		pw.print("<form name='frmurl' method='post'>");
		
		pw.print("Enter your email:<input type='text' name='txtemail'/>");
		pw.print("<br/><br/><input type='submit' value='Show Message'/>");    

		pw.print("</form>");
		pw.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();  
	
        response.setContentType("text/html");  
        
        String email = request.getParameter("txtemail");  
       
        pw.print("Welcome " + email);  

        pw.print("<br/><br/><a href='URLRewritingEx1_1?myemail=" + email +"'>Subscribe Me</a>");  

        /*RequestDispatcher rd = request.getRequestDispatcher
        			("URLRewritingEx1_1?myemail=" + email);
        rd.forward(request, response);*/
	}
}
