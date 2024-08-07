package com.servlet.connector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servlet4() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String validUsername = "Priyank";
		String validPassword = "0911";
		PrintWriter pw = resp.getWriter();
		if(validUsername.equals(username) && validPassword.equals(password)) {
			pw.write("<html>");
			pw.write("<body>");
			pw.write("<h1>Login Successful</h1>");
			pw.write("<p>Welcome "+username+" !</p>");
			pw.write("</body>");
			pw.write("</html>");
		}
		else {
			pw.write("<html>");
			pw.write("<body>");
			pw.write("<h1>Login Failed</h1>");
			pw.write("<p>Invalid Username/Password</p>");
			pw.write("</body>");
			pw.write("</html>");
		}
	}

}
