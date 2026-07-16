package mypack;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out
                = response.getWriter();

        int score = 0;

        int total = 2;

        for (int i = 1; i <= total; i++) {
            String userAnswer
                    = request.getParameter("q" + i);

            String correctAnswer
                    = request.getParameter("ans" + i);

            if (userAnswer != null
                    && userAnswer.equals(correctAnswer)) {
                score++;
            }
        }

        out.println("<html><body>");

        out.println("<h1>Quiz Result</h1>");

        out.println(
                "<h2>Total Questions : "
                + total
                + "</h2>");

        out.println(
                "<h2>Correct Answers : "
                + score
                + "</h2>");

        out.println(
                "<h2>Score : "
                + score
                + "/"
                + total
                + "</h2>");

        out.println("</body></html>");
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
