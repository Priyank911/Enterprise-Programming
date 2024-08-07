package com.practices.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginSuccess")
public class loginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginSuccess() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = "";
		boolean flag = false;

		if(request.getCookies()!=null) {
			for(Cookie cookie : request.getCookies()){
				if(cookie.getName().equals("username")){
					username = cookie.getValue();
					flag = true;
					break;
				}
			}
		}
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		if(!flag) {
			pw.print("<h1>Cookies expired !");
		}
		else
		{
			pw.print("<h1>Welcome, " + username + "</h1>");
			pw.print("<h1><a href='CookieExample1_Logout'>Logout</h1>");
		}
	}
}
