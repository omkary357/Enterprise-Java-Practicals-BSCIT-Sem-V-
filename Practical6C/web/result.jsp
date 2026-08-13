<%@page contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"
          prefix="c"%>
<html>
    <head>
        <title>JSTL Example</title>
    </head>
    <body>
        <h2>JSTL Demonstration</h2>
        <hr>
    <c:set var="student"
           value="${param.name}"/>
    <c:set var="marks"
           value="${param.marks}"/>
    <h3>Using c:out</h3>
    Name :
    <c:out value="${student}"/>
    <br>
    Marks :
    <c:out value="${marks}"/>
    <hr>
    <h3>Using c:if</h3>
    <c:if test="${marks>=35}">
        Student is Pass
    </c:if>
    <c:if test="${marks<35}">
        Student is Fail
    </c:if>
    <hr>
    <h3>Using c:choose</h3>
    <c:choose>
        <c:when test="${marks>=75}">
            Grade A
        </c:when>
        <c:when test="${marks>=60}">
            Grade B
        </c:when>
        <c:when test="${marks>=35}">
            Grade C
        </c:when>
        <c:otherwise>
            Grade F
        </c:otherwise>
    </c:choose>
    <hr>
    <h3>Using c:forEach</h3>
    <c:forEach begin="1"
               end="5"
               var="i">
        Roll No :
        ${i}
        <br>
    </c:forEach>
    <hr>
    <h3>Using c:remove</h3>
    <c:remove var="student"/>
    Student Variable Removed Successfully
</body>
</html>