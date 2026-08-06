<%@page contentType="text/html"%>

<html>

    <head>

        <title>Room Reservation</title>

    </head>

    <body>

        <h2>Room Reservation System</h2>

        <form action="RoomServlet" method="post">

            Customer Name

            <input type="text"
                   name="name"
                   required>

            <br><br>

            Room Type

            <select name="room">

                <option>Single</option>

                <option>Double</option>

                <option>Suite</option>

            </select>

            <br><br>

            Check In

            <input type="date"
                   name="checkin"
                   required>

            <br><br>

            Check Out

            <input type="date"
                   name="checkout"
                   required>

            <br><br>

            <input type="submit"
                   value="Reserve Room">

        </form>

    </body>

</html>