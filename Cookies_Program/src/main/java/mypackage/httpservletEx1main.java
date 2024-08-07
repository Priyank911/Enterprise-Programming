package mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class httpservletEx1main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public httpservletEx1main() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 PrintWriter pw = response.getWriter(); 
			 response.setContentType("text/html");  
			 pw.print("<html><body>"); 
			 pw.print("<form name='frmlogin' method='post'>"); 
			 pw.print("<p>Username: <input type='text' name='username'/></p>"); 
			 pw.print("<p>Password: <input type='password' name='password'></p>"); 
			 pw.print("<input type='submit' value='Login'>"); 
			 pw.print("</form>"); 
			 pw.print("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{ 
			 response.setContentType("text/html"); 
			 PrintWriter pw = response.getWriter(); 
			 
			 String name = request.getParameter("username"); 
			 String password = 
			request.getParameter("password"); 
			 
			 HttpSession session = request.getSession(); 
			 //Set the data to the session 
			 session.setAttribute("username",name); 
			 session.setAttribute("password",password); 
			 
			 pw.print("<a href='httpsessionEx1'>Click to GO!</a>"); 
			 pw.close(); 
			 } 
			 catch(Exception exp) 
			 { 
			 System.out.println(exp); 
			 }
	}

}
