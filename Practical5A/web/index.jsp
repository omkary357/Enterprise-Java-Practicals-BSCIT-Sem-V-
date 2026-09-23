<%@ page language="java"
         contentType="text/html"
         pageEncoding="UTF-8"
         import="java.util.Date" %>

<%@ include file="header.jsp" %>

<html>

    <head>

        <title>JSP Directives and Implicit Objects</title>

    </head>

    <body>

        <h3>1. Page Directive</h3>

        <p>
            Language: Java
        </p>

        <p>
            Current Date:
            <%= new Date()%>
        </p>

        <hr>

        <h3>2. Request Implicit Object</h3>

        <p>
            Request Method:
            <%= request.getMethod()%>
        </p>

        <p>
            Request URI:
            <%= request.getRequestURI()%>
        </p>

        <p>
            Server Name:
            <%= request.getServerName()%>
        </p>

        <p>
            Server Port:
            <%= request.getServerPort()%>
        </p>

        <hr>

        <h3>3. Response Implicit Object</h3>

        <p>
            Response Content Type:
            <%= response.getContentType()%>
        </p>

        <hr>

        <h3>4. Session Implicit Object</h3>

        <p>
            Session ID:
            <%= session.getId()%>
        </p>

        <p>
            Session Creation Time:
            <%= new Date(session.getCreationTime())%>
        </p>

        <p>
            Session Last Accessed Time:
            <%= new Date(session.getLastAccessedTime())%>
        </p>

        <hr>

        <h3>5. Application Implicit Object</h3>

        <p>
            Server Information:
            <%= application.getServerInfo()%>
        </p>

        <p>
            Application Context Path:
            <%= application.getContextPath()%>
        </p>

        <hr>

        <h3>6. Out Implicit Object</h3>

        <%
            out.println("This message is displayed using the out object.");
        %>

        <hr>

        <h3>7. Config Implicit Object</h3>

        <p>
            Servlet Name:
            <%= config.getServletName()%>
        </p>

        <hr>

        <h3>8. PageContext Implicit Object</h3>

        <p>
            Page Context Class:
            <%= pageContext.getClass().getName()%>
        </p>

        <hr>

        <h3>9. Page Implicit Object</h3>

        <p>
            Page Class:
            <%= page.getClass().getName()%>
        </p>

        <hr>

        <h3>JSP Directive Information</h3>

        <p>
            The page directive specifies page-level properties
            such as language, content type, encoding and imported classes.
        </p>

        <p>
            The include directive includes the contents of another JSP file
            into the current JSP page.
        </p>

    </body>

</html>