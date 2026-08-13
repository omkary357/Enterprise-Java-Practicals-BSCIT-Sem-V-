package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RoomServlet extends HttpServlet {

    @EJB
    RoomBean bean;

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        String room = request.getParameter("room");

        String checkin = request.getParameter("checkin");

        String checkout = request.getParameter("checkout");

        boolean status = bean.reserveRoom(
                name,
                room,
                checkin,
                checkout);

        out.println("<html>");
        out.println("<body>");

        out.println("<h2>Room Reservation System</h2>");

        if (status) {

            out.println("<h3>Room Reserved Successfully.</h3>");

        } else {

            out.println("<h3>Reservation Failed.</h3>");

        }

        out.println("<br>");

        out.println("<a href='index.jsp'>Back</a>");

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