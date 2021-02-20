<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: IT-academyGomel
  Date: 20.02.2021
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/head.jsp" />

<form action="<c:url value="/front" />" method="post">
    <input name="command" type="hidden" value="Login" />
    <input name="login" type="text" placeholder="Enter login.."/>
    <input name="password" type="password" placeholder="Enter password.."/>
    <input type="submit" value="Login.."/>
</form>


</body>
</html>
