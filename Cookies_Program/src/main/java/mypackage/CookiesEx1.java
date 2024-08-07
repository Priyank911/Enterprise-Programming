package mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookiesEx1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CookiesEx1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.write("<html>");
        pw.write("<head><title>Login</title></head>");
        pw.write("<body>");
        pw.write("<h1>Login</h1>");
        pw.write("<form name='frmlogin' method='post'>");
        pw.write("<p>Username : <input type='text' name='username'></p>");
        pw.write("<p>Password : <input type='password' name='password'></p>");
        pw.write("<input type='submit' value='Login'>");
        pw.write("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        pw.write("<html><body>");
        if (username.equals("Priyank") && password.equals("0911")) {
            Cookie logincookie = new Cookie("username", username);
            logincookie.setMaxAge(1 * 60);
            response.addCookie(logincookie);
            System.out.println("Redirecting to LoginSuccess");
            response.sendRedirect("LoginSuccess");
        } else {
            pw.write("<p>Invalid username or password</p>");
        }
        pw.write("</body></html>");
    }
}
