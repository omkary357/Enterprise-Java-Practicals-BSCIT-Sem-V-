<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Student Registration</title>
    </head>

    <body>

        <h2>Student Registration Form</h2>

        <form action="result.jsp" method="post">

            Name :
            <input type="text" name="name" required>

            <br><br>

            Age :
            <input type="number" name="age" required>

            <br><br>

            Email :
            <input type="email" name="email" required>

            <br><br>

            Gender :

            <input type="radio"
                   name="gender"
                   value="Male"
                   required>Male

            <input type="radio"
                   name="gender"
                   value="Female">Female

            <br><br>

            Hobbies :

            <input type="checkbox"
                   name="hobby"
                   value="Reading">Reading

            <input type="checkbox"
                   name="hobby"
                   value="Sports">Sports

            <input type="checkbox"
                   name="hobby"
                   value="Music">Music

            <input type="checkbox"
                   name="hobby"
                   value="Travel">Travel

            <br><br>

            <input type="submit"
                   value="Submit">

        </form>

    </body>
</html>