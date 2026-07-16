package mypack;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ValidateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String password = request.getParameter("password");

        if(password.equals("Servlet"))
        {
            RequestDispatcher rd =
                    request.getRequestDispatcher("WelcomeServlet");

            rd.forward(request, response);
        }
        else
        {
            out.println("<font color='red'>Invalid Password</font><br><br>");

            RequestDispatcher rd =
                    request.getRequestDispatcher("/index.html");

            rd.include(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }
}