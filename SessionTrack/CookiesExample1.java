package com.practices.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

@WebServlet("/CookiesExample1")
public class CookiesExample1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		pw.print("<html><body>");

		pw.print("<form name='frmlogin' method='post'>");

		pw.print("Username: <br/><input type='text' name='txtuser'/><br>");
		pw.print("Password: <br/><input type='password' name='txtpassword'><br>");
		pw.print("<br/><input type='submit' value='Login'>");
		pw.print("</form>");
		pw.print("</body></html>");	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		pw.print("<html><body>");

		String username = request.getParameter("txtuser");
		String password = request.getParameter("txtpassword");
		
		if(username.equals("admin") && password.equals("admin"))
		{
			
			//response.addCookie(new Cookie("username", username));
			
			Cookie loginCookie = new Cookie("username",username);
			loginCookie.setMaxAge(1*60);  //setting cookie to expiry in 30 mins
			response.addCookie(loginCookie);
			
			response.sendRedirect("loginSuccess");
		}
		else
		{
			pw.println("<h1>Invalid username / password</<h1>");
		}
	}
}
