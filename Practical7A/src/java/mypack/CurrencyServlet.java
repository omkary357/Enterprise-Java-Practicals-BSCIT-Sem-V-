package mypack;

import java.io.*;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

public class CurrencyServlet extends HttpServlet {

    @EJB
    CurrencyBean bean;

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        double amount = Double.parseDouble(
                request.getParameter("amount"));

        String type = request.getParameter("type");

        double result = bean.convert(amount, type);

        out.println("<html>");
        out.println("<body>");

        out.println("<h2>Currency Converter</h2>");

        out.println("<br>");

        out.println("Converted Amount = " + result);

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
