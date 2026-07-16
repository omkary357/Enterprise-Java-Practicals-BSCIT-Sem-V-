<%@page import="java.sql.*"%>

<%

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    try {

        Class.forName("org.apache.derby.jdbc.ClientDriver");

        Connection con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/StudentDB",
                "root",
                "root");

        PreparedStatement ps = con.prepareStatement(
                "select * from users where username=? and password=?");

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            session.setAttribute("user", username);
            response.sendRedirect("welcome.jsp");
        } else {
            out.println("<h2>Invalid Username or Password</h2>");
        }

        con.close();

    } catch (Exception e) {
        out.println(e);
    }

%>