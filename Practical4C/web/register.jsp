<%@page contentType="text/html"%>

<html>
    <head>
        <title>Registration</title>
    </head>

    <body>

        <h2>User Registration</h2>

        <form action="registerProcess.jsp" method="post">

            Username :
            <input type="text" name="username" required>

            <br><br>

            Password :
            <input type="password" name="password" required>

            <br><br>

            Email :
            <input type="email" name="email" required>

            <br><br>

            <input type="submit" value="Register">

        </form>

        <br>

        <a href="login.jsp">Already Registered? Login</a>

    </body>
</html>