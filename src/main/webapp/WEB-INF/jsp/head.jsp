<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.02.2021
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Head</title>
</head>
<body>

<form action="<c:url value="/front" ><c:param name="command" value="Login"/></c:url>" method="post">
    <input name="login" type="text" placeholder="Enter login.."/>
    <input name="password" type="password" placeholder="Enter password.."/>
    <input type="submit" value="Login.."/>
</form>

<c:url value="/front" scope="request" var="logup">
    <c:param name="command" value="Forward"/>
    <c:param name="forward" value="registration"/>
</c:url>
<a href="<c:out value="${logup}"/>">Registration</a>







</body>
</html>
