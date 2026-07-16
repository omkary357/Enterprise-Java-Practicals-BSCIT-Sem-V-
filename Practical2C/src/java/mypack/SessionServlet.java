package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        String user = (String) session.getAttribute("user");

        out.println("<html><body>");

        if(user == null)
        {
            session.setAttribute("user", "Visitor");

            out.println("<h2>Welcome!</h2>");
            out.println("<h3>This is your FIRST visit.</h3>");
        }
        else
        {
            out.println("<h2>Welcome Back!</h2>");
            out.println("<h3>You have visited earlier.</h3>");
        }

        out.println("<br>");
        out.println("<a href='LogoutServlet'>Logout</a>");

        out.println("</body></html>");
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