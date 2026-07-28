<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Expression Language Demo</title>
    </head>
    <body>
        <h2>Expression Language Output</h2>
        <hr>
        <h3>1. Parameter Object</h3>
        Name :
        ${param.name}
        <br>
        Age :
        ${param.age}
        <br>
        Course :
        ${param.course}
        <hr>
        <h3>2. Parameter Values</h3>
        First Hobby :
        ${paramValues.hobby[0]}
        <br>
        Second Hobby :
        ${paramValues.hobby[1]}
        <hr>
        <h3>3. Session Scope</h3>
        Username :
        ${sessionScope.username}
        <hr>
        <h3>4. Application Scope</h3>
        College :
        ${applicationScope.college}
        <hr>
        <h3>5. Cookie</h3>
        City :
        ${cookie.City.value}
        <hr>
        <h3>6. Header Object</h3>
        Browser :
        ${header["User-Agent"]}
        <br><br>
        Host :
        ${header.Host}
        <hr>
        <h3>7. Arithmetic Operators</h3>
        20 + 10 =
        ${20+10}
        <br>
        20 - 10 =
        ${20-10}
        <br>
        20 * 10 =
        ${20*10}
        <br>
        20 / 10 =
        ${20/10}
        <br>
        20 % 3 =
        ${20%3}
        <hr>
        <h3>8. Relational Operators</h3>
        20 > 10 :
        ${20>10}
        <br>
        20 < 10 :
        ${20<10}
        <br>
        20 == 20 :
        ${20==20}
        <hr>
        <h3>9. Logical Operators</h3>
        ${true && true}
        <br>
        ${true || false}
        <br>
        ${!false}
        <hr>
        <h3>10. Empty Operator</h3>
        ${empty param.address}
        <hr>
        <h3>11. Conditional Operator</h3>
        ${param.age>=18?"Eligible to Vote":"Not Eligible"}
    </body>
</html>