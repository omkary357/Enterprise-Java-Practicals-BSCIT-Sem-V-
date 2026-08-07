package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet {
        
    @EJB
    ShoppingCartBean bean;

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String item = request.getParameter("item");

        String action = request.getParameter("action");

        if(action.equals("Add"))
        {

            bean.addItem(item);

        }

        else if(action.equals("Clear"))
        {

            bean.clearCart();

        }

        ArrayList<String> cart = bean.getItems();

        out.println("<html>");

        out.println("<body>");

        out.println("<h2>Shopping Cart</h2>");

        out.println("<b>Items in Cart</b><br><br>");

        for(String s : cart)
        {

            out.println(s+"<br>");

        }

        out.println("<br>");

        out.println("Total Items : "
                +bean.getTotalItems());

        out.println("<br><br>");

        out.println("<a href='index.jsp'>Back</a>");

        out.println("</body>");

        out.println("</html>");

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