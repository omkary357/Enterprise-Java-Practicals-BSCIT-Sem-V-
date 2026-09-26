<%@page import="java.util.List"%>
<%@page import="entity.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Practical 10.c: Hibernate Employee Management</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f0f2f5; margin: 30px; }
        .wrapper { max-width: 950px; margin: 0 auto; background: white; padding: 25px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
        h2 { color: #1a365d; margin-top: 0; }
        .layout { display: flex; gap: 30px; margin-top: 20px; }
        .form-side { flex: 1; background: #f8fafc; padding: 20px; border-radius: 6px; border: 1px solid #e2e8f0; }
        .table-side { flex: 2; }
        .form-group { margin-bottom: 12px; }
        label { display: block; font-weight: bold; margin-bottom: 5px; color: #4a5568; font-size: 14px; }
        input[type=text], input[type=number] { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #cbd5e0; border-radius: 4px; }
        input[type=submit] { background-color: #2b6cb0; color: white; border: none; padding: 10px 16px; border-radius: 4px; cursor: pointer; font-size: 15px; width: 100%; margin-top: 10px; font-weight: bold; }
        input[type=submit]:hover { background-color: #2c5282; }
        table { width: 100%; border-collapse: collapse; margin-top: 10px; }
        th, td { border: 1px solid #e2e8f0; padding: 10px; text-align: left; }
        th { background-color: #3182ce; color: white; font-size: 14px; }
        tr:nth-child(even) { background-color: #f7fafc; }
    </style>
</head>
<body>
    <div class="wrapper">
        <h2>Practical 10.c: Store and Retrieve Employee Details (Hibernate & JavaDB)</h2>
        <hr/>

        <div class="layout">
            <!-- Form to Store Employee Details -->
            <div class="form-side">
                <h3 style="margin-top:0; color:#2d3748;">Store Employee</h3>
                <form action="EmployeeServlet" method="POST">
                    <div class="form-group">
                        <label>Employee Name:</label>
                        <input type="text" name="name" placeholder="e.g. John Doe" required />
                    </div>

                    <div class="form-group">
                        <label>Designation:</label>
                        <input type="text" name="designation" placeholder="e.g. Software Engineer" required />
                    </div>

                    <div class="form-group">
                        <label>Department:</label>
                        <input type="text" name="department" placeholder="e.g. IT / Development" required />
                    </div>

                    <div class="form-group">
                        <label>Salary (₹):</label>
                        <input type="number" step="0.01" name="salary" placeholder="e.g. 55000.00" required />
                    </div>

                    <input type="submit" value="Save via Hibernate" />
                </form>
            </div>

            <!-- Table to Retrieve Employee Details -->
            <div class="table-side">
                <h3 style="margin-top:0; color:#2d3748;">Retrieved Employees (HQL)</h3>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Designation</th>
                            <th>Department</th>
                            <th>Salary</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Employee> list = (List<Employee>) request.getAttribute("employees");
                            if (list != null && !list.isEmpty()) {
                                for (Employee emp : list) {
                        %>
                        <tr>
                            <td><%= emp.getId() %></td>
                            <td><%= emp.getName() %></td>
                            <td><%= emp.getDesignation() %></td>
                            <td><%= emp.getDepartment() %></td>
                            <td>₹ <%= emp.getSalary() %></td>
                        </tr>
                        <%
                                }
                            } else {
                        %>
                        <tr>
                            <td colspan="5" style="text-align: center; color: #a0aec0;">No employees found in JavaDB.</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>