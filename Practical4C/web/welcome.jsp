<%@page contentType="text/html"%>

<html>

    <head>
        <title>Welcome</title>
    </head>

    <body>

        <h2>

            Welcome

            <%=session.getAttribute("user")%>

        </h2>

    </body>

</html>