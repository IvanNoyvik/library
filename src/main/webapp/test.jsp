<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.03.2021
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TEST</title>
</head>
<body>
<c:forEach var="order" items="${requestScope.orders}" >

    <c:if test="${order.now() > order.date.plusDays(order.duration)}">
        <h3>Book is expired
            return the book to the library</h3>
        <div class="detail_button"><a href="subpage.html">Return</a></div>
    </c:if>
    <c:if test="${order.now() < order.date.plusDays(order.duration)}">
        <div class="buy_now_button"><a href="subpage.html">Read</a></div>
        <h3> Expected return date: ${order.date.plusDays(order.duration)} </h3>
        <h3>${order.date.plusDays(order.duration).toEpochDay() - order.now().toEpochDay()} days left </h3>
        <div class="detail_button"><a href="subpage.html">Return</a></div>
    </c:if>



</c:forEach>
<br>
<br>
</body>
</html>
