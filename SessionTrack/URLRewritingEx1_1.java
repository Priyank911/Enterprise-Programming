package com.practices.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/URLRewritingEx1_1")
public class URLRewritingEx1_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showdata(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showdata(request, response);
	}
	public void showdata(HttpServletRequest request, 
			HttpServletResponse response) {
		try {
            PrintWriter pw = response.getWriter();
            response.setContentType("text/html");

            pw.print("<html><body>");
            String email = request.getParameter("myemail");
            pw.print("<h1>Hello " + email + "</h1>");

            pw.print("</body></html>");
        }
        catch (Exception e) {
            System.out.println(e);
        }
	}
}
