<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.02.2021
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/head.jsp" />

<br>
<form action="/front" method="post" >
  <p> <input name="login" type="text"/> </p>   <br />
    <p>  <input name="password" type="password"/> </p><br />
    <p>  <input name="name" type="text"/> </p><br />
    <input name="command" type="hidden" value="Registration" /> <br />
    <p> <input type="submit" value="Registration"/></p>
</form>
</body>
</html>
