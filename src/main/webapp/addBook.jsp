<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Add Book</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="<c:url value="/static/main/templatemo_style.css" />" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="templatemo_container">

    <c:import url="head.jsp"/>

    <div id="templatemo_header">
        <div id="templatemo_special_offers">
            <p>
                <c:if test="${!empty requestScope.resp}">
                    <span class="resp"><c:out value="${requestScope.resp}"/></span>
                </c:if>
            </p>
        </div>

        <div id="templatemo_new_books">

        </div>
    </div>


    <div id="templatemo_content">

        <div id="templatemo_content_left">
            <div class="templatemo_content_left_section">

            </div>
            <div class="templatemo_content_left_section">

            </div>


        </div>


        <div id="templatemo_content_right">
            <c:if test="${sessionScope.user.role.role.equalsIgnoreCase('Administrator')}">

                <h1>Create new book: </h1>

                <form action="<c:url value="/front"/>" method="post">
                    <input name="command" type="hidden" value="AddBook"/>

                    <label>Title: </label>
                    <input name="title" required type="text" value="title"/>

                    <div class="product_info">

                        <label> Genre:
                            <select name="genre">
                                <option disabled>Select genre</option>
                                <c:forEach items="${requestScope.genres}" var="genre">
                                    <option value="${genre.id}">${genre.genre}</option>
                                </c:forEach>
                            </select>
                        </label>
                        <br/>

                        <label> Author:
                            <select name="author">
                                <c:forEach items="${requestScope.authors}" var="author">
                                    <option value="${author.id}">${author.author}</option>
                                </c:forEach>
                            </select>
                        </label>
                        <br/>
                        <label>Quantity:
                            <input name="quantity" required type="text"
                                   value="quantity"/></label>
                        <br/>

                        <label>Description:
                            <textarea name="description" cols="30" rows="5"></textarea><br/>
                        </label>

                        <input type="submit" value="submit"/>


                        <c:url value="/front" var="Cancel">
                            <c:param name="command" value="Forward"/>
                            <c:param name="forward" value="main"/>
                        </c:url>
                        <div class="buy_now_button"><a href="<c:out value="${Cancel}"/>">Cancel</a></div>
                    </div>

                    <div class="cleaner_with_height">&nbsp;</div>

                </form>

            </c:if>
        </div>


        <div class="cleaner_with_height">&nbsp;</div>
    </div>

    <div id="templatemo_footer">

        <a href="#"><strong>About me</strong></a>
    </div>

</div>

</body>
</html>