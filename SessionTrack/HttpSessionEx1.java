package com.practices.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HttpSessionEx1")
public class HttpSessionEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		pw.print("<html><body>");

		pw.print("<form name='frmlogin' method='post'>");

		pw.print("Username: <br/><input type='text' name='txtuser'/><br>");
		pw.print("Password: <br/><input type='password' name='txtpassword'><br>");
		pw.print("<br/><br/><input type='submit' value='Login'>");
		pw.print("</form>");
		pw.print("</body></html>");	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
	
		    String name = request.getParameter("txtuser");
		    String password = request.getParameter("txtpassword");
		    
		    HttpSession session = request.getSession();

		    //Set the data to the session
		    session.setAttribute("uname",name);
		    session.setAttribute("upass",password);
		    
		    pw.print("<a href='HttpSessionEx1_1'>Click to GO!</a>");
		    pw.close();
	    }
		catch(Exception exp)
		{
	       System.out.println(exp);
	    }
	}
}
