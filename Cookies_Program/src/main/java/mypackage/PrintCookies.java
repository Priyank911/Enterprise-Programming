package mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class PrintCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrintCookies() {
        super();
        
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html"); 
		 PrintWriter pw = resp.getWriter(); 
		 pw.write("<html><head><title>Cookies</title></head><body>"); 
		 pw.write("<h2>Cookies from your browser</h2>"); 
		 Cookie[] cookies = req.getCookies(); 
		 if(cookies != null) { 
		 for(Cookie cookie : cookies) { 
		 pw.write("<h3>Cookie name = "+cookie.getName()+", Cookie Value = "+cookie.getValue()+"</h3>"); 
		 } 
		 } 
		 else { 
		 pw.write("<p>No Cookies Found</p>"); 
		 } 
		 pw.write("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
