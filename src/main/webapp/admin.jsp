<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Admin panel</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="<c:url value="/static/admin/admin.css" />" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="templatemo_container">

    <c:import url="head.jsp"/>

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
            <ul>
                <c:if test="${!empty requestScope.error}">
                    <li>Error</li>
                    <li>Error</li>
                    <li>Error</li>
                </c:if>

            </ul>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->

    <!-- PAGE CONTENT: start -->
    <div id="templatemo_content">

        <!-- CATEGORY FILTER: start -->
        <div id="templatemo_content_left">
            <div class="templatemo_content_left_section">
                <h1>Overdue orders</h1>
                <c:if test="${!empty requestScope.orders && sessionScope.user.role.role.equalsIgnoreCase('Administrator')}">
                    <c:forEach items="${requestScope.orders}" var="order">

                        <div class="templatemo_product_box">

                            <h2>${order.user.login} <span>(${order.user.name})</span></h2>

                            <h3> Overdue the book <span>(${order.book.title})</span> by
                                    ${order.now().toEpochDay() - order.date.plusDays(order.duration).toEpochDay()} days
                            </h3>
                            <div class="product_info">
                                <c:if test="${!order.user.status.status.equalsIgnoreCase('Limited')}">
                                    <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                        <label placeolder="duration">
                                            <input name="duration" required type="text" placeolder="duration"/>
                                        </label>
                                        <input name="command" type="hidden" value="ChangeStatus"/>
                                        <input name="userId" type="hidden" value="${order.user.id}"/>
                                        <input name="status" type="hidden" value="Limited"/>
                                        <input type="submit" value="Limited"/>
                                    </form>
                                </c:if>
                                <c:if test="${!order.user.status.status.equalsIgnoreCase('Locked')}">
                                    <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                        <input name="command" type="hidden" value="ChangeStatus"/>
                                        <input name="userId" type="hidden" value="${order.user.id}"/>
                                        <input name="status" type="hidden" value="Locked"/>
                                        <input type="submit" value="Locked"/>
                                    </form>
                                </c:if>
                                <c:if test="${!order.user.status.status.equalsIgnoreCase('OK')}">
                                    <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                        <input name="command" type="hidden" value="ChangeStatus"/>
                                        <input name="userId" type="hidden" value="${order.user.id}"/>
                                        <input name="status" type="hidden" value="OK"/>
                                        <input type="submit" value="Unlocked"/>
                                    </form>
                                </c:if>

                            </div>

                        </div>

                    </c:forEach>

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
            <h1>Users</h1>

            <c:if test="${!empty requestScope.users}">
                <table>
                    <tr>
                        <th>OK User</th>
                        <th>Limited User</th>
                        <th>Locked User</th>
                    </tr>
                    <c:forEach items="${requestScope.users}" var="user">
                        <tr>
                            <td>
                                <c:if test="${user.status.status.equalsIgnoreCase('OK')}">

                                </c:if>
                            </td>
                            <td>
                                <c:if test="${user.status.status.equalsIgnoreCase('Limited')}">

                                </c:if>
                            </td>
                            <td>
                                <c:if test="${user.status.status.equalsIgnoreCase('Locked')}">

                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </c:if>

            <!-- BOOK: end -->

        </div> <!-- end of content right -->

        <div class="cleaner_with_height">&nbsp;</div>
        <!-- PAGE CONTENT: end -->

        <div id="templatemo_footer">

            <a href="/test">TEST</a> | <a href="subpage.html">Search</a> | <a href="subpage.html">Books</a> | <a
                href="#">New Releases</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br/>
            Copyright © 2024 <a href="#"><strong>Your Company Name</strong></a>
            <!-- Credit: www.templatemo.com -->    </div>

    </div> <!-- end of container -->

</body>
</html>