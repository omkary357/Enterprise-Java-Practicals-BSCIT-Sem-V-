package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisitCounterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int count = 0;
        boolean found = false;

        Cookie cookies[] = request.getCookies();

        if (cookies != null) {

            for (Cookie c : cookies) {

                if (c.getName().equals("visitCount")) {

                    count = Integer.parseInt(c.getValue());
                    count++;
                    found = true;

                    Cookie cookie =
                            new Cookie("visitCount",
                                    String.valueOf(count));

                    response.addCookie(cookie);

                    break;
                }
            }
        }

        if (!found) {

            count = 1;

            Cookie cookie =
                    new Cookie("visitCount",
                            String.valueOf(count));

            response.addCookie(cookie);
        }

        out.println("<html>");
        out.println("<body>");
        out.println("<h2>You have visited this servlet "
                + count + " times.</h2>");
        out.println("</body>");
        out.println("</html>");
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