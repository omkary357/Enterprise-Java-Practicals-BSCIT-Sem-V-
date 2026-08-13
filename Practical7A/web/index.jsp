<%@page contentType="text/html"%>

<html>

    <head>

        <title>Currency Converter</title>

    </head>

    <body>

        <h2>Currency Converter using EJB</h2>

        <form action="CurrencyServlet" method="post">

            Amount

            <input type="text" name="amount">

            <br><br>

            <select name="type">

                <option value="INR_TO_USD">

                    INR To USD

                </option>

                <option value="USD_TO_INR">

                    USD To INR

                </option>

            </select>

            <br><br>

            <input type="submit"
                   value="Convert">

        </form>

    </body>

</html>