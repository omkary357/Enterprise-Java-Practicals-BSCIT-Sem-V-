
<%@page import="java.sql.*"%>

<%

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");

    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");

        Connection con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/StudentDB",
                "root",
                "root");

        PreparedStatement ps = con.prepareStatement(
                "insert into users values(?,?,?)");

        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, email);

        int i = ps.executeUpdate();

        if (i > 0) {
            response.sendRedirect("login.jsp");
        }

        con.close();

    } catch (Exception e) {
        out.println(e);
    }

%>