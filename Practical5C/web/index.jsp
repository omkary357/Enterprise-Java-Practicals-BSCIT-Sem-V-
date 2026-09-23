<%@ page language="java"
         contentType="text/html"
         pageEncoding="UTF-8"
         import="java.sql.*" %>

<html>

    <head>

        <title>Student Details</title>

    </head>

    <body>

        <h2>Student Details from Java DB</h2>

        <%

            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                // Load Java DB JDBC Driver
                Class.forName(
                        "org.apache.derby.jdbc.ClientDriver"
                );

                // Establish connection
                con = DriverManager.getConnection(
                        "jdbc:derby://localhost:1527/College",
                        "root",
                        "root"
                );

                // Create Statement
                stmt = con.createStatement();

                // Execute SELECT query
                rs = stmt.executeQuery(
                        "SELECT * FROM student"
                );

        %>

        <table border="1">

            <tr>

                <th>Roll No</th>
                <th>Name</th>
                <th>Age</th>
                <th>Course</th>

            </tr>

            <%    while (rs.next()) {

            %>

            <tr>

                <td>
                    <%= rs.getInt("rollno")%>
                </td>

                <td>
                    <%= rs.getString("name")%>
                </td>

                <td>
                    <%= rs.getInt("age")%>
                </td>

                <td>
                    <%= rs.getString("course")%>
                </td>

            </tr>

            <%

                }

            %>

        </table>

        <%} catch (Exception e) {

        %>

        <h3>Error Occurred</h3>

        <p>
            <%= e.getMessage()%>
        </p>

        <%

                e.printStackTrace();

            } finally {

                try {
                    if (rs != null) {
                        rs.close();
                    }

                    if (stmt != null) {
                        stmt.close();
                    }

                    if (con != null) {
                        con.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        %>

    </body>

</html>