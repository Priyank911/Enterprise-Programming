package mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class httpsessionEx1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public httpsessionEx1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();

            String myName = null, myPass = null;
            HttpSession session = request.getSession(false);

            pw.write("<html><body>");
            if (session == null || session.getAttribute("username") == null) {
                response.sendRedirect("HttpSessionEx1");
            } else {
                myName = (String) session.getAttribute("username");
                myPass = (String) session.getAttribute("password");

                pw.write("<p>Username :- " + myName + "</p>");
                pw.write("<p>Password :- " + myPass + "</p>");
                pw.write("<p>Creation Time of Session (ms) :- " + session.getCreationTime() + "</p>");
                pw.write("<p>Creation Date :- " + new Date(session.getCreationTime()) + "</p>");
                pw.write("<p>Last Accessed (ms) :- " + session.getLastAccessedTime() + "</p>");
                pw.write("<p>Last Accessed Date :- " + new Date(session.getLastAccessedTime()) + "</p>");
            }
            pw.write("</body></html>");
            pw.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
