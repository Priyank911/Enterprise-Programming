package com.servlet.connector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servlet2() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<html>");
		pw.write("<body>");
		pw.write("<p>Request Method :- "+request.getMethod()+"</p>");
		pw.write("<p>Request URI :- "+request.getRequestURI()+"</p>");
		pw.write("<p>Context Path :- "+request.getContextPath()+"</p>");
		pw.write("<p>Servlet Path :- "+request.getServletPath()+"</p>");
		pw.write("</body>");
		pw.write("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
