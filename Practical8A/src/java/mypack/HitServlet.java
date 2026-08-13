package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HitServlet extends HttpServlet {

    @EJB
    HitCounterBean bean;

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int hits = bean.getHitCount();

        out.println("<html>");

        out.println("<body>");

        out.println("<h2>Servlet Hit Counter Using Singleton EJB</h2>");

        out.println("<br>");

        out.println("<h3>Total Hits : " + hits + "</h3>");

        out.println("<br>");

        out.println("<a href='index.jsp'>Refresh Again</a>");

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
