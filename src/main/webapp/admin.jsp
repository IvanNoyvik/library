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


    <c:import url="head.jsp"/>

    <div id="admin_header">
        <div id="admin_special_offers">
            <p>
                <c:if test="${!empty requestScope.resp}">
                    <span class="resp"><c:out value="${requestScope.resp}"/></span>
                </c:if>
            </p>
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
        </div>
    </div>

    <div id="admin_content">

        <div id="admin_content_left">
            <div class="admin_content_left_section">
                <h1>Overdue orders</h1>
                <c:if test="${!empty requestScope.orders && sessionScope.user.role.role.equalsIgnoreCase('Administrator')}">
                    <c:forEach items="${requestScope.orders}" var="order">

                        <div class="admin_product_box">

                            <h2>${order.user.login} <span>(${order.user.name})</span></h2>

                            <h3> Overdue the book <span>(${order.book.title})</span> by
                                    ${applicationScope.now.now().toEpochDay() - order.date.plusDays(order.duration).toEpochDay()}
                                days
                            </h3>
                            <div class="product_info">
                                <c:if test="${!order.user.status.status.equalsIgnoreCase('Limited')}">
                                    <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                        <label>Duration
                                            <input name="duration" type="text" class="duration"/>
                                        </label>
                                        <input name="command" type="hidden" value="ChangeStatus"/>
                                        <input name="userId" type="hidden" value="${order.user.id}"/>
                                        <input name="status" type="hidden" value="Limited"/>
                                        <input class="submit-limit" type="submit" value="Limited"/>
                                    </form>
                                </c:if>
                                <c:if test="${!order.user.status.status.equalsIgnoreCase('Locked')}">
                                    <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                        <input name="command" type="hidden" value="ChangeStatus"/>
                                        <input name="userId" type="hidden" value="${order.user.id}"/>
                                        <input name="status" type="hidden" value="Locked"/>
                                        <input class="submit-lock" type="submit" value="Locked"/>
                                    </form>
                                </c:if>
                                <c:if test="${!order.user.status.status.equalsIgnoreCase('OK')}">
                                    <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                        <input name="command" type="hidden" value="ChangeStatus"/>
                                        <input name="userId" type="hidden" value="${order.user.id}"/>
                                        <input name="status" type="hidden" value="OK"/>
                                        <input class="submit-unlock" type="submit" value="Unlocked"/>
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
                                <input class="submit-unlock" type="submit" value="Unlocked"/>
                            </form>

                        </div>

                    </c:forEach>
                </c:if>

            </div>


        </div>

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
                                                <input class="duration" name="duration" type="text"/>
                                            </label>
                                            <input name="command" type="hidden" value="ChangeStatus"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input name="status" type="hidden" value="Limited"/>
                                            <input class="submit-limit" type="submit" value="Limited"/>
                                        </form>
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="ChangeStatus"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input name="status" type="hidden" value="OK"/>
                                            <input class="submit-unlock" type="submit" value="Unlocked"/>
                                        </form>
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="DeleteUser"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input class="submit-delete" type="submit" value="Delete"/>
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
                                            <input class="submit-lock" type="submit" value="Locked"/>
                                        </form>
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="ChangeStatus"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input name="status" type="hidden" value="OK"/>
                                            <input class="submit-unlock" type="submit" value="Unlocked"/>
                                        </form>
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="DeleteUser"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input class="submit-delete" type="submit" value="Delete"/>
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
                                                <input name="duration" class="duration" type="text"/>
                                            </label>
                                            <input name="command" type="hidden" value="ChangeStatus"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input name="status" type="hidden" value="Limited"/>
                                            <input class="submit-limit" type="submit" value="Limited"/>
                                        </form>
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="ChangeStatus"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input name="status" type="hidden" value="Locked"/>
                                            <input class="submit-lock" type="submit" value="Locked"/>
                                        </form>
                                    </h3>
                                </td>
                                <td>
                                    <h3>
                                        <form accept-charset="UTF-8" action="<c:url value="/front"/>" method="post">
                                            <input name="command" type="hidden" value="DeleteUser"/>
                                            <input name="userId" type="hidden" value="${userMap.key.id}"/>
                                            <input class="submit-delete" type="submit" value="Delete"/>
                                        </form>
                                    </h3>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>

                </table>

            </c:if>


        </div>

        <div class="cleaner_with_height">&nbsp;</div>
    </div>

    <div id="admin_footer">

        <a href="#"><strong>About me</strong></a>
    </div>
</div>

</body>
</html>