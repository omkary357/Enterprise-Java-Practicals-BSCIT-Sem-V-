package servlet;

import ejb.VisitorStatsBean;
import java.io.IOException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VisitorServlet", urlPatterns = {"/VisitorServlet"})
public class VisitorServlet extends HttpServlet {

    // Default GlassFish JMS Connection Factory
    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;

    // The JMS Queue
    @Resource(lookup = "jms/VisitorQueue")
    private Queue queue;

    // Injected Singleton Bean to fetch current statistics
    @EJB
    private VisitorStatsBean statsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Send statistics to JSP
        request.setAttribute("totalVisitors", statsBean.getTotalVisitors());
        request.setAttribute("visitorLog", statsBean.getVisitorLog());
        request.getRequestDispatcher("stats.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String visitorName = request.getParameter("visitorName");
        String city = request.getParameter("city");

        String payload = "Visitor: " + visitorName + " | City: " + city;

        // Send message asynchronously to JMS Queue
        sendJMSMessageToQueue(payload);

        // Allow a brief moment for the MDB to process before redirecting
        try {
            Thread.sleep(200);
        } catch (InterruptedException ignored) {
        }

        response.sendRedirect("VisitorServlet");
    }

    private void sendJMSMessageToQueue(String text) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);

            TextMessage message = session.createTextMessage(text);
            producer.send(message);

            producer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
