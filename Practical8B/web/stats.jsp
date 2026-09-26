<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Visitor Statistics (MDB)</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f7fafc; margin: 30px; }
        .container { max-width: 800px; margin: 0 auto; background: white; padding: 25px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
        h2 { color: #2d3748; }
        .stats-badge { background-color: #4299e1; color: white; padding: 15px; border-radius: 6px; font-size: 20px; font-weight: bold; text-align: center; margin-bottom: 25px; }
        .form-box { background: #edf2f7; padding: 20px; border-radius: 6px; margin-bottom: 25px; }
        label { display: block; font-weight: bold; margin-bottom: 5px; color: #4a5568; }
        input[type=text] { width: 100%; padding: 8px; margin-bottom: 12px; border: 1px solid #cbd5e0; border-radius: 4px; box-sizing: border-box; }
        input[type=submit] { background-color: #48bb78; color: white; padding: 10px 18px; border: none; border-radius: 4px; cursor: pointer; font-size: 15px; font-weight: bold; }
        input[type=submit]:hover { background-color: #38a169; }
        ul { list-style-type: none; padding-left: 0; }
        li { background: #f7fafc; border-left: 4px solid #4299e1; padding: 10px; margin-bottom: 8px; border-radius: 3px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Practical 8.b: Visitor Statistics using Message Driven Bean [MDB]</h2>
        <hr/>

        <!-- Live Statistics Counter -->
        <%
            Integer total = (Integer) request.getAttribute("totalVisitors");
            if (total == null) total = 0;
        %>
        <div class="stats-badge">
            Total Visits Processed by MDB: <%= total %>
        </div>

        <!-- Form to Trigger a New Visit -->
        <div class="form-box">
            <h3>Record a New Visitor</h3>
            <form action="VisitorServlet" method="POST">
                <label>Your Name:</label>
                <input type="text" name="visitorName" placeholder="e.g. Omkar" required />

                <label>City / Location:</label>
                <input type="text" name="city" placeholder="e.g. Mumbai" required />

                <input type="submit" value="Submit Visit (Send JMS Message)" />
            </form>
        </div>

        <!-- Asynchronous Visitor Log -->
        <h3>Recent Visitors Log (Processed Asynchronously)</h3>
        <ul>
            <%
                List<String> log = (List<String>) request.getAttribute("visitorLog");
                if (log != null && !log.isEmpty()) {
                    for (int i = log.size() - 1; i >= 0; i--) {
            %>
            <li><%= log.get(i) %></li>
            <%
                    }
                } else {
            %>
            <li style="color: gray; border-left-color: gray;">No visitor messages received yet.</li>
            <%
                }
            %>
        </ul>
    </div>
</body>
</html>