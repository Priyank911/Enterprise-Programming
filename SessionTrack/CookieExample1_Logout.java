package com.practices.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieExample1_Logout")
public class CookieExample1_Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
    	Cookie loginCookie = null;
    	Cookie[] cookies = request.getCookies();
    	String fname;
    
    	if(cookies != null){
    		for(Cookie cookie : cookies){
	    		if(cookie.getName().equals("username")){
	    			loginCookie = cookie;
	    			break;
	    		}
    		}
    	}
    	if(loginCookie != null){
    		loginCookie.setMaxAge(0); //Cookie will expire in 0 second
        	response.addCookie(loginCookie); // Attach cookie to response
    	}
    	response.sendRedirect("CookiesExample1");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
