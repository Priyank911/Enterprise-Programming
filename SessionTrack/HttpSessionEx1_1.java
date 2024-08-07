package com.practices.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HttpSessionEx1_1")
public class HttpSessionEx1_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		      response.setContentType("text/html");
		      PrintWriter pw = response.getWriter();
		      
		      String myName = null, myPass = null;
		      
		      HttpSession session=request.getSession(false);
		      
		      //session.removeAttribute("uname");
		      
		      if(session.getAttribute("uname")==null) {
		    	  response.sendRedirect("HttpSessionEx1");
		      }
		      else
		      {
		    	  myName=(String)session.getAttribute("uname");
		    	  myPass=(String)session.getAttribute("upass");
			      pw.print("<h1>Username : " + myName + "<br/> Password : " + myPass + "</h1>");
		      }
		      pw.close();
		}
		catch(Exception exp){
			System.out.println(exp);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
