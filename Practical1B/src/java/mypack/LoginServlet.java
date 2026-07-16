package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Hardcoded username and password
            if(username.equals("adminadmin") && password.equals("12341234")) {

                out.println("<html>");
                out.println("<body>");
                out.println("<h2>Hello " + username + "</h2>");
                out.println("</body>");
                out.println("</html>");

            } else {

                out.println("<html>");
                out.println("<body>");
                out.println("<h2>Login Failed</h2>");
                out.println("</body>");
                out.println("</html>");

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}