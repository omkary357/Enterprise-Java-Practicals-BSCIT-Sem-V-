package mypack;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MCQServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            Class.forName(
                    "org.apache.derby.jdbc.ClientDriver");

            Connection con
                    = DriverManager.getConnection(
                            "jdbc:derby://localhost:1527/QADB",
                            "root",
                            "root");

            Statement st
                    = con.createStatement();

            ResultSet rs
                    = st.executeQuery(
                            "select * from MCQ");

            out.println("<html><body>");

            out.println(
                    "<h2>Online MCQ Test</h2>");

            out.println(
                    "<form action='CheckServlet' method='post'>");

            while (rs.next()) {

                int id
                        = rs.getInt("ID");

                out.println("<hr>");

                out.println("<h3>");

                out.println(
                        id + ". "
                        + rs.getString("QUESTION"));

                out.println("</h3>");

                out.println(
                        "<input type='radio' name='q"
                        + id
                        + "' value='"
                        + rs.getString("OPT1")
                        + "'>"
                        + rs.getString("OPT1")
                        + "<br>");

                out.println(
                        "<input type='radio' name='q"
                        + id
                        + "' value='"
                        + rs.getString("OPT2")
                        + "'>"
                        + rs.getString("OPT2")
                        + "<br>");

                out.println(
                        "<input type='radio' name='q"
                        + id
                        + "' value='"
                        + rs.getString("OPT3")
                        + "'>"
                        + rs.getString("OPT3")
                        + "<br>");

                out.println(
                        "<input type='radio' name='q"
                        + id
                        + "' value='"
                        + rs.getString("OPT4")
                        + "'>"
                        + rs.getString("OPT4")
                        + "<br><br>");

                out.println(
                        "<input type='hidden' name='ans"
                        + id
                        + "' value='"
                        + rs.getString("ANSWER")
                        + "'>");
            }

            out.println(
                    "<input type='submit' value='Submit Quiz'>");

            out.println("</form>");

            out.println("</body></html>");

            con.close();

        } catch (Exception e) {

            out.println(e);

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
