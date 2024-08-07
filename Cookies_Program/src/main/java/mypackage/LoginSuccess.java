package mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginSuccess extends HttpServlet {

    public LoginSuccess() {
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
		 pw.print("<h1><a href='CookiesEx1_logout'>Logout</h1>"); 
		 }
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
