<%@ page language="java"
         contentType="text/html"
         pageEncoding="UTF-8" %>

<html>

    <head>

        <title>Form Processing and Validation</title>

    </head>

    <body>

        <h2>Student Registration Form</h2>

        <form action="process.jsp" method="post">

            Name:
            <input type="text" name="name">

            <br><br>

            Age:
            <input type="text" name="age">

            <br><br>

            Email:
            <input type="text" name="email">

            <br><br>

            Gender:

            <input type="radio"
                   name="gender"
                   value="Male">

            Male

            <input type="radio"
                   name="gender"
                   value="Female">

            Female

            <br><br>

            Hobbies:

            <input type="checkbox"
                   name="hobby"
                   value="Reading">

            Reading

            <input type="checkbox"
                   name="hobby"
                   value="Sports">

            Sports

            <input type="checkbox"
                   name="hobby"
                   value="Music">

            Music

            <br><br>

            <input type="submit"
                   value="Submit">

            <input type="reset"
                   value="Reset">

        </form>

    </body>

</html>