<%@page contentType="text/html"%>

<html>

    <head>

        <title>Shopping Cart</title>

    </head>

    <body>

        <h2>Shopping Cart Application</h2>

        <form action="CartServlet" method="post">

            Product

            <select name="item">

                <option>Laptop</option>

                <option>Mobile</option>

                <option>Keyboard</option>

                <option>Mouse</option>

                <option>Headphones</option>

            </select>

            <br><br>

            <input type="submit"
                   name="action"
                   value="Add">

            <input type="submit"
                   name="action"
                   value="Clear">

        </form>

    </body>

</html>