<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <head>

        <title>Intrinsic Objects</title>

    </head>

    <body>

        <h2>Values of JSP Intrinsic Objects</h2>

        <hr>

        <b>Request Method :</b>

        <%= request.getMethod()%>

        <br><br>

        <b>Request URI :</b>

        <%= request.getRequestURI()%>

        <br><br>

        <b>Server Name :</b>

        <%= request.getServerName()%>

        <br><br>

        <b>Server Port :</b>

        <%= request.getServerPort()%>

        <br><br>

        <b>Session ID :</b>

        <%= session.getId()%>

        <br><br>

        <b>Application Name :</b>

        <%= application.getServletContextName()%>

        <br><br>

        <%
            out.println("<b>Message using out object :</b> Hello Students");
        %>

    </body>

</html>