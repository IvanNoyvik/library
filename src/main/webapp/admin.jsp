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
<div id="admin_container">

    <div id="admin_menu">
        <ul>

            <c:if test="${empty sessionScope.user}">
                <!-- LOGIN -->
                <c:url value="/front" var="login">
                    <c:param name="command" value="Forward"/>
                    <c:param name="forward" value="login"/>
                </c:url>
                <li><a href="<c:out value="${login}"/>" class="current">Login</a></li>

                <!-- REGISTR -->
                <c:url value="/front" var="registration">
                    <c:param name="command" value="Forward"/>
                    <c:param name="forward" value="registration"/>
                </c:url>
                <li><a href="<c:out value="${registration}"/>" class="current">Registration</a></li>
            </c:if>


            <c:if test="${!empty sessionScope.user}">
                <!-- LOGOUT -->
                <c:url value="/front" var="logout">
                    <c:param name="command" value="Logout"/>
                </c:url>
                <li><a href="<c:out value="${logout}"/>" class="current">Logout</a></li>

                <!-- PROFILE -->
                <c:if test="${sessionScope.user.status.status ne 'Locked'}">

                    <c:url value="/front" var="profile">
                        <c:param name="command" value="Forward"/>
                        <c:param name="forward" value="profile"/>
                        <c:param name="userId" value="${sessionScope.user.id}"/>
                    </c:url>
                    <li><a href="<c:out value="${profile}"/>"
                           class="current">${sessionScope.user.login}(${sessionScope.user.name})</a></li>
                </c:if>


            </c:if>
        </ul>
    </div>

    <div id="admin_header">
        <div id="admin_special_offers">
            <p>
                <c:if test="${requestScope.message eq 'regostration'}">
                    You have successfully registered!
                </c:if>
            </p>

            <ul>
                <c:if test="${!empty requestScope.error}">
                    <li>Error</li>
                    <li>Error</li>
                    <li>Error</li>
                </c:if>

            </ul>
        </div>


        <div id="admin_new_books">
            <ul>
                <li>
                    <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                        <input name="genre" required type="text" value="Genre"/>
                        <input name="command" type="hidden" value="AddGenre"/>
                        <input type="submit" value="Add genre"/>
                    </form>
                </li>
                <li>
                    <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                        <input name="author" required type="text" value="Author"/>
                        <input name="command" type="hidden" value="AddAuthor"/>
                        <input type="submit" value="Add author"/>
                    </form>
                </li>
                <li>
                    <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                        <input name="forward" type="hidden" value="addBook"/>
                        <input name="command" type="hidden" value="Forward"/>
                        <input type="submit" value="Add book"/>
                    </form>
                </li>
            </ul>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->

    <!-- PAGE CONTENT: start -->
    <div id="admin_content">

        <!-- CATEGORY FILTER: start -->
        <div id="admin_content_left">
            <div class="admin_content_left_section">
                <h1>Overdue orders</h1>
                <c:if test="${!empty requestScope.orders && sessionScope.user.role.role.equalsIgnoreCase('Administrator')}">
                    <c:forEach items="${requestScope.orders}" var="order">

                        <div class="admin_product_box">

                            <h2>${order.user.login} <span>(${order.user.name})</span></h2>

                            <h3> Overdue the book <span>(${order.book.title})</span> by
                                    ${applicationScope.now.now().toEpochDay() - order.date.plusDays(order.duration).toEpochDay()} days
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
            <div class="admin_content_left_section">
                <h1>Messages</h1>
                <c:if test="${!empty requestScope.messages}">
                    <c:forEach items="${requestScope.messages}" var="mess">
                        <div class="admin_product_box">
                            <h2>From: ${mess.user.login} <span>(${mess.user.name})</span> ${mess.dateSent}</h2>
                            <div class="product_info">
                                    ${mess.content}
                            </div>
                            <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                <input name="command" type="hidden" value="ChangeStatus"/>
                                <input name="userId" type="hidden" value="${mess.user.id}"/>
                                <input name="status" type="hidden" value="OK"/>
                                <input type="submit" value="Unlocked"/>
                            </form>

                        </div>

                    </c:forEach>
                </c:if>

            </div>


        </div>
        <!-- CATEGORY FILTER: end -->

        <div id="admin_content_right">
            <h1>Users</h1>

            <c:if test="${!empty requestScope.users}">
                <table>
                    <tr>
                        <th><h2>Login</h2></th>
                        <th><h2>User Status</h2></th>
                        <th><h2>Count Overdue Order</h2></th>
                        <th><h2> Change</h2></th>
                        <th><h2> Status </h2></th>
                        <th><h2>Delete User</h2></th>

                    </tr>
                    <c:forEach items="${requestScope.users}" var="userMap">
                        <c:if test="${userMap.key.status.status.equalsIgnoreCase('Locked')}">
                            <tr>
                                <td><h3>${userMap.key.login}</h3></td>
                                <td><h3>${userMap.key.status.status}</h3></td>
                                <td><h3>${userMap.value}</h3></td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <label>
                                                <input name="duration" required type="text"/>
                                            </label>
                                            <input name="command" type="hidden" value="ChangeStatus"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input name="status" type="hidden" value="Limited"/>
                                            <input type="submit" value="Limited"/>
                                        </form>
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="ChangeStatus"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input name="status" type="hidden" value="OK"/>
                                            <input type="submit" value="Unlocked"/>
                                        </form>
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="DeleteUser"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input type="submit" value="Delete"/>
                                        </form>
                                    </h3>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>

                    <c:forEach items="${requestScope.users}" var="userMap">
                        <c:if test="${userMap.key.status.status.equalsIgnoreCase('Limited')}">
                            <tr>
                                <td><h3>${userMap.key.login}</h3></td>
                                <td><h3>${userMap.key.status.status}</h3></td>
                                <td><h3>${userMap.value}</h3></td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="ChangeStatus"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input name="status" type="hidden" value="Locked"/>
                                            <input type="submit" value="Locked"/>
                                        </form>
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="ChangeStatus"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input name="status" type="hidden" value="OK"/>
                                            <input type="submit" value="Unlocked"/>
                                        </form>
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="DeleteUser"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input type="submit" value="Delete"/>
                                        </form>
                                    </h3>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>

                    <c:forEach items="${requestScope.users}" var="userMap">
                        <c:if test="${userMap.key.status.status.equalsIgnoreCase('OK')}">
                            <tr>
                                <td><h3>${userMap.key.login}</h3></td>
                                <td><h3>${userMap.key.status.status}</h3></td>
                                <td><h3>${userMap.value}</h3></td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <label>
                                                <input name="duration" required type="text"/>
                                            </label>
                                            <input name="command" type="hidden" value="ChangeStatus"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input name="status" type="hidden" value="Limited"/>
                                            <input type="submit" value="Limited"/>
                                        </form>
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="ChangeStatus"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input name="status" type="hidden" value="Locked"/>
                                            <input type="submit" value="Locked"/>
                                        </form>
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="DeleteUser"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input type="submit" value="Delete"/>
                                        </form>
                                    </h3>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>

                </table>

            </c:if>

            <!-- BOOK: end -->

        </div> <!-- end of content right -->

        <div class="cleaner_with_height">&nbsp;</div>
        <!-- PAGE CONTENT: end -->

        <div id="admin_footer">

            <a href="/test">TEST</a> | <a href="subpage.html">Search</a> | <a href="subpage.html">Books</a> | <a
                href="#">New Releases</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br/>
            Copyright © 2024 <a href="#"><strong>Your Company Name</strong></a>
            <!-- Credit: www.admin.com -->    </div>

    </div> <!-- end of container -->

</body>
</html>