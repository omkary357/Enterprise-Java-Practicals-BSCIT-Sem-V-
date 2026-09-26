package servlet;

import entity.Employee;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/EmployeeServlet"})
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // RETRIEVE: Fetch all employees using Hibernate Query Language (HQL)
            List<Employee> employees = session.createQuery("FROM Employee").list();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("employee.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error retrieving employees: " + e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String designation = request.getParameter("designation");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            // STORE: Save employee object using Hibernate ORM
            Employee emp = new Employee(name, designation, department, salary);
            session.save(emp);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new ServletException("Error saving employee: " + e.getMessage(), e);
        } finally {
            session.close();
        }

        // Redirect back to doGet to refresh table
        response.sendRedirect("EmployeeServlet");
    }

    @Override
    public void destroy() {
        HibernateUtil.shutdown();
    }
}
