<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/head.jsp" />

<br>
<form action="/front" method="post">
  <p> <input name="login" type="text"/> </p>   <br />
    <p>  <input name="password" type="password"/> </p><br />
    <p>  <input name="name" type="text"/> </p><br />
    <input name="command" type="hidden" value="Registration" datafld="Registration" />
    <p> <input type="submit" value="Registration"/></p>
</form>
<br>
registration
</body>
</html>
