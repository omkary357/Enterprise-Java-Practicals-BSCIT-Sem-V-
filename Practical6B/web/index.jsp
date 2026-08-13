<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    application.setAttribute("college", "XYZ College");
    session.setAttribute("username", "Omkar");
    Cookie ck = new Cookie("City", "Mumbai");
    response.addCookie(ck);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Expression Language Demo</title>
    </head>
    <body>
        <h2>Expression Language Demonstration</h2>
        <form action="result.jsp" method="post">
            Name :
            <input type="text" name="name">
            <br><br>
            Age :
            <input type="number" name="age">
            <br><br>
            Course :
            <input type="text" name="course">
            <br><br>
            Hobbies :
            <input type="checkbox"
                   name="hobby"
                   value="Reading">
            Reading
            <input type="checkbox"
                   name="hobby"
                   value="Music">
            Music
            <input type="checkbox"
                   name="hobby"
                   value="Sports">
            Sports
            <br><br>
            <input type="submit"
                   value="Submit">
        </form>
    </body>
</html>