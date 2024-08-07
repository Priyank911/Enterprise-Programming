package com.servlet.connector;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class servlet1 extends HttpServlet {
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.write("<html>");
			pw.write("<body>");
			pw.write("<h1> Hello World </h1>");
			pw.write("</body>");
			pw.write("</html>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
