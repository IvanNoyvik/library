<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Profile</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="<c:url value="/static/main/templatemo_style.css" />" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="templatemo_container">

    <div id="templatemo_menu">
        <ul>

            <c:if test="${!empty sessionScope.user}">
                <!-- LOGOUT -->
                <c:url value="/front" var="logout">
                    <c:param name="command" value="Logout"/>
                </c:url>
                <li><a href="<c:out value="${logout}"/>" class="current">Logout</a></li>

                <c:url value="/front" var="main">
                    <c:param name="command" value="Forward"/>
                    <c:param name="forward" value="main"/>
                </c:url>
                <li><a href="<c:out value="${main}"/>" class="current">Back to menu</a></li>
            </c:if>
        </ul>
    </div>

    <div id="templatemo_header">
        <div id="templatemo_special_offers">
            <p>
                <c:if test="${requestScope.message eq 'regostration'}">
                    You have successfully registered!
                </c:if>
            </p>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>


        <div id="templatemo_new_books">
            <c:if test="${!empty sessionScope.user}">

                <ul>
                    <li>You login: ${user.login}</li>
                    <li>You name: ${user.name}</li>
                </ul>
                <a href="<c:url value="/editUser.jsp" />" style="margin-left: 50px;">Edit profile...</a>
            </c:if>

        </div>
    </div> <!-- end of header -->

    <!-- PAGE CONTENT: start -->
    <div id="templatemo_content">

        <!-- CATEGORY FILTER: start -->
        <div id="templatemo_content_left">
            <div class="templatemo_content_left_section">
                <c:if test="${sessionScope.user.role.role eq 'Administrator'}">
                    <form action="<c:url value="/front"/>" method="post">
                        <input type="hidden" name="command" value="Forward"/>
                        <input type="hidden" name="forward" value="admin"/>
                        <h1><input type="submit" value="Admin panel"/></h1>
                    </form>
                </c:if>

            </div>
            <div class="templatemo_content_left_section">
                <h1>Bestsellers</h1>
                <ul>
                    <li><a href="#">Vestibulum ullamcorper</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                    <li><a href="#">Praesent mattis varius</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                    <li><a href="#">Flash Templates</a></li>
                    <li><a href="#">CSS Templates</a></li>
                    <li><a href="#">Web Design</a></li>
                </ul>
            </div>


        </div>
        <!-- CATEGORY FILTER: end -->

        <div id="templatemo_content_right">

            <c:if test="${!empty requestScope.orders}">

                <c:forEach items="${requestScope.orders}" var="order">

                    <!-- BOOK: start -->
                    <div class="templatemo_product_box">


                        <h1>${order.book.title} </h1>

                        <c:url value="/front" var="image">
                            <c:param name="bookId" value="${order.book.id}"/>
                            <c:param name="command" value="GetImage"/>
                        </c:url>
                        <div>
                            <img src="${image}" alt="CSS Template" width="100"
                                 height="100"/>
                        </div>
                        <div class="product_info">
                            <p>${order.book.description}</p>

                            <c:if test="${applicationScope.now.now() >= order.date.plusDays(order.duration)}">
                                <h3>Book is expired
                                    return the book to the library</h3>
                                <%--                                <c:url value="/front" var="return">--%>
                                <%--                                    <c:param name="command" value="ReturnOrder"/>--%>
                                <%--                                    <c:param name="id" value="${order.id}"/>--%>
                                <%--                                </c:url>--%>
                                <div class="detail_button"><a
                                        href="<c:url value="/front?command=ReturnOrder&id=${order.id}"/>">Return</a>
                                </div>
                            </c:if>
                            <c:if test="${applicationScope.now.now() < order.date.plusDays(order.duration)}">
                                <h3> Expected return date: ${order.date.plusDays(order.duration)} </h3>
                                <h3>${order.date.plusDays(order.duration).toEpochDay() - applicationScope.now.now().toEpochDay()}
                                    days
                                    left </h3>
                                <div class="buy_now_button"><a class="buy_now_button" href="subpage.html">Read</a></div>

                                <div class="detail_button"><a
                                        href="<c:url value="/front?command=ReturnOrder&id=${order.id}"/>">Return</a>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <!-- Insert empty string after book -->
                </c:forEach>

            </c:if>
            <!-- BOOK: end -->

        </div> <!-- end of content right -->

        <div class="cleaner_with_height">&nbsp;</div>

        <div id="templatemo_footer">

            <a href="subpage.html">Home</a> | <a href="subpage.html">Search</a> | <a href="subpage.html">Books</a> | <a
                href="#">New Releases</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br/>
            Copyright © 2024 <a href="#"><strong>Your Company Name</strong></a>
            <!-- Credit: www.templatemo.com -->
        </div>
    </div>
    <!-- PAGE CONTENT: end -->


</div> <!-- end of container -->

</body>
</html>