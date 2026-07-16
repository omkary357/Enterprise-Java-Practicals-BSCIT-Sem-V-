/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author omkar
 */
public class CalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");

    try (PrintWriter out = response.getWriter()) {

        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("operation");

        double result = 0;

        if(operation.equals("add")) {
            result = num1 + num2;
        }
        else if(operation.equals("sub")) {
            result = num1 - num2;
        }
        else if(operation.equals("mul")) {
            result = num1 * num2;
        }
        else if(operation.equals("div")) {
            if(num2 != 0) {
                result = num1 / num2;
            } else {
                out.println("<h2>Division by zero is not allowed!</h2>");
                return;
            }
        }

        out.println("<html>");
        out.println("<head><title>Calculator Result</title></head>");
        out.println("<body>");
        out.println("<h2>Calculator Result</h2>");
        out.println("<p>First Number: " + num1 + "</p>");
        out.println("<p>Second Number: " + num2 + "</p>");
        out.println("<p>Result: " + result + "</p>");
        out.println("<a href='index.html'>Back</a>");
        out.println("</body>");
        out.println("</html>");
    }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
