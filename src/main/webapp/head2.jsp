<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<style>--%>
<%--    <%@include file='/WEB-INF/static/main/templatemo_style.css' %>--%>
<%--</style>--%>
<html>
<head>
    <title>MAIN2</title>
</head>
<body>

<div id="templatemo_container">
    <div id="templatemo_menu">
        <ul>

            <!-- LOGIN -->
           <c:url value="/front" scope="request" var="login">
                <c:param name="command" value="Forward"/>
                <c:param name="forward" value="login"/>
            </c:url>
            <li><a href="<c:out value="${login}"/>" class="current">Login</a></li>

            <!-- LOGOUT -->
            <c:url value="/front" scope="request" var="logout">
                <c:param name="command" value="Forward"/>
                <c:param name="forward" value="logout"/>
            </c:url>
            <li><a href="<c:out value="${logout}"/>" class="current">Logout</a></li>

            <!-- REGISTR -->
            <c:url value="/front" scope="request" var="registration">
                <c:param name="command" value="Forward"/>
                <c:param name="forward" value="registration"/>
            </c:url>
            <li><a href="<c:out value="${registration}"/>" class="current">Registration</a></li>

            <!-- PROFILE -->
            <li><a href="profile.html" class="current">Profile</a></li>

        </ul>
    </div> <!-- end of menu -->

    <div id="templatemo_header">
        <div id="templatemo_special_offers">
            <p>
                <span>25%</span> discounts for
                purchase over $80
            </p>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>


        <div id="templatemo_new_books">
            <ul>
                <li>Suspen disse</li>
                <li>Maece nas metus</li>
                <li>In sed risus ac feli</li>
            </ul>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->


</div>




</body>
</html>

