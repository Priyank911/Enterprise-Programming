package com.practices.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HiddeFieldMsg")
public class HiddeFieldMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HiddeFieldMsg() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txtemail");
        String time = request.getParameter("visittime");
        
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        pw.write("<h3>Hello " + email + "<br/><br/>Welcome to Page ! " +
        		"<br/><br/>You visited Home page at " + time + "</h3>");
	}
}
