<%@ page language="java"
         contentType="text/html"
         pageEncoding="UTF-8" %>

<html>

    <head>

        <title>Form Processing Result</title>

    </head>

    <body>

        <h2>Form Processing Result</h2>

        <%

            String name = request.getParameter("name");

            String age = request.getParameter("age");

            String email = request.getParameter("email");

            String gender = request.getParameter("gender");

            String[] hobbies
                    = request.getParameterValues("hobby");

            boolean valid = true;

            // Name validation
            if (name == null || name.trim().equals("")) {

                out.println("<p>Name is required.</p>");

                valid = false;

            } else if (!name.matches("[a-zA-Z ]+")) {

                out.println("<p>Name should contain only alphabets.</p>");

                valid = false;

            }

            // Age validation
            if (age == null || age.trim().equals("")) {

                out.println("<p>Age is required.</p>");

                valid = false;

            } else {

                try {

                    int ageValue
                            = Integer.parseInt(age);

                    if (ageValue < 1 || ageValue > 100) {

                        out.println(
                                "<p>Age must be between 1 and 100.</p>"
                        );

                        valid = false;

                    }

                } catch (NumberFormatException e) {

                    out.println(
                            "<p>Age must contain numbers only.</p>"
                    );

                    valid = false;

                }

            }

            // Email validation
            if (email == null || email.trim().equals("")) {

                out.println("<p>Email is required.</p>");

                valid = false;

            } else if (!email.matches(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

                out.println(
                        "<p>Enter a valid email address.</p>"
                );

                valid = false;

            }

            // Gender validation
            if (gender == null
                    || gender.trim().equals("")) {

                out.println(
                        "<p>Please select gender.</p>"
                );

                valid = false;

            }

            // Hobby validation
            if (hobbies == null
                    || hobbies.length == 0) {

                out.println(
                        "<p>Select at least one hobby.</p>"
                );

                valid = false;

            }

            // Display result
            if (valid) {

        %>

        <h3>Form Submitted Successfully!</h3>

        <p>
            Name: <%= name%>
        </p>

        <p>
            Age: <%= age%>
        </p>

        <p>
            Email: <%= email%>
        </p>

        <p>
            Gender: <%= gender%>
        </p>

        <p>
            Hobbies:

            <%

                for (String hobby : hobbies) {

                    out.print(hobby + " ");

                }

            %>

        </p>

        <%} else {

        %>

        <h3>Form Submission Failed</h3>

        <p>Please correct the above errors.</p>

        <%    }

        %>

        <br>

        <a href="index.jsp">
            Go Back to Form
        </a>

    </body>

</html>