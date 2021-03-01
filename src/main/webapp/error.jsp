<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>You have a problem...</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<c:url value="/static/main/templatemo_style.css" />" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="templatemo_container">

    <c:import url="head.jsp" />

    <div id="templatemo_header">
        <div id="templatemo_special_offers">
            <p>
                <c:if test="${requestScope.message eq 'regostration'}">
                    You have successfully registered!
                </c:if>
            </p>
        </div>


        <div id="templatemo_new_books">
            <ul>
                <c:if test="${param.error}">
                    <li>Error</li>
                    <li>Error</li>
                    <li>Error</li>
                </c:if>

            </ul>
        </div>
    </div> <!-- end of header -->

    <!-- PAGE CONTENT: start -->
    <div id="templatemo_content">

        <!-- CATEGORY FILTER: start -->
        <div id="templatemo_content_left">
            <div class="templatemo_content_left_section">
                <ul>

                </ul>
            </div>
            <div class="templatemo_content_left_section">
                <ul>

                </ul>
            </div>


        </div>

        <div id="templatemo_content_right">


        </div> <!-- end of content right -->

    </div>
    <!-- PAGE CONTENT: end -->

    <div id="templatemo_footer">

        <a href="subpage.html">Home</a> | <a href="subpage.html">Search</a> | <a href="subpage.html">Books</a> | <a href="#">New Releases</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
        Copyright © 2024 <a href="#"><strong>Your Company Name</strong></a>
        <!-- Credit: www.templatemo.com -->    </div>

</div> <!-- end of container -->

</body>
</html>