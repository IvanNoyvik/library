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

<c:url value="/front" scope="request" var="login">
    <c:param name="command" value="Forward"/>
    <c:param name="forward" value="login"/>
</c:url>
<a href="<c:out value="${login}"/>">Login</a>

<c:url value="/front" scope="request" var="registration">
    <c:param name="command" value="Forward"/>
    <c:param name="forward" value="registration"/>
</c:url>
<a href="<c:out value="${registration}"/>">Registration</a>

<c:url value="/front" scope="request" var="logout">
    <c:param name="command" value="Forward"/>
    <c:param name="forward" value="logout"/>
</c:url>

<a href="<c:out value="${logout}"/>">Logout</a>


</body>
</html>
