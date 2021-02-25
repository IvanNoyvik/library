<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Head</title>
</head>
<body>
<br>
head
<br>
<c:if test="${empty sessionScope.user}">
<c:url value="/front" var="login">
    <c:param name="command" value="Forward"/>
    <c:param name="forward" value="login"/>
</c:url>
<a href="<c:out value="${login}"/>">Login</a>


<c:url value="/front" var="registration">
    <c:param name="command" value="Forward"/>
    <c:param name="forward" value="registration"/>
</c:url>
<a href="<c:out value="${registration}"/>">Registration</a>
</c:if>

<c:if test="${!empty sessionScope.user}">
<c:url value="/front" var="logout">
    <c:param name="command" value="Logout"/>
</c:url>
<a href="<c:out value="${logout}"/>">Logout</a>

</c:if>


</body>
</html>
