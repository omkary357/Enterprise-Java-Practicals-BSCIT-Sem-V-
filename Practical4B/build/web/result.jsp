<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    String name = request.getParameter("name");
    String age = request.getParameter("age");
    String email = request.getParameter("email");
    String gender = request.getParameter("gender");
    String hobbies[] = request.getParameterValues("hobby");

    if (name == null || name.trim().equals("")
            || age == null || age.trim().equals("")
            || email == null || email.trim().equals("")
            || gender == null) {
%>

<h2 style="color:red">
    Validation Failed!
</h2>

<a href="index.jsp">
    Go Back
</a>

<%
} else {
%>

<html>

    <head>

        <title>Result</title>

    </head>

    <body>

        <h2>Student Details</h2>

        <hr>

        <b>Name :</b>

        <%=name%>

        <br><br>

        <b>Age :</b>

        <%=age%>

        <br><br>

        <b>Email :</b>

        <%=email%>

        <br><br>

        <b>Gender :</b>

        <%=gender%>

        <br><br>

        <b>Hobbies :</b>

        <%

            if (hobbies != null) {
                for (String h : hobbies) {
                    out.print(h + " ");
                }
            } else {
                out.print("None");
            }

        %>

    </body>

</html>

<%    }
%>