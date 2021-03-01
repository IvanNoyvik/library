<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Book</title>
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
                <a href="/editUser.jsp" style="margin-left: 50px;">Edit profile...</a>
            </c:if>

        </div>
    </div> <!-- end of header -->

    <!-- PAGE CONTENT: start -->
    <div id="templatemo_content">

        <!-- CATEGORY FILTER: start -->
        <div id="templatemo_content_left">
            <div class="templatemo_content_left_section">
                <h1>Categories</h1>
                <ul>
                    <li><a href="subpage.html">Donec accumsan urna</a></li>
                    <li><a href="subpage.html">Proin vulputate justo</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                    <li><a href="#">Aliquam tristique dolor</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">Sed pellentesque placerat</a></li>
                    <li><a href="#">Suspen disse</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                </ul>
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


        <c:if test="${!empty requestScope.book}">

            <div id="templatemo_content_right">

                <h1>${book.title} <span>(${book.author.author})</span></h1>
                <div class="image_panel"><img src="<c:url value="${book.coverLink}" />" alt="CSS Template" width="100"
                                              height="150"/></div>

                <div class="product_info">
                    <p>${book.description}</p>
                    <c:if test="${book.quantity == 0}">
                        <h3>Not available</h3>
                    </c:if>
                    <c:if test="${book.quantity > 0}">
                        <h3>${book.quantity} pcs in stock</h3>
                        <div class="buy_now_button"><a href="subpage.html">Add in my library</a></div>
                    </c:if>
                    <ul>
                        <li>January 2024</li>
                        <li>Pages: 498</li>
                        <li>ISBN 10: 0-496-91612-0 | ISBN 13: 9780492518154</li>
                    </ul>

                    <p>${book.description}</p>


                    <div class="buy_now_button"><a href="subpage.html">Read</a></div>
                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
                </div>

                <div class="cleaner_with_height">&nbsp;</div>

                <a href="index.html"><img src="images/templatemo_ads.jpg" alt="css template ad"/></a>

            </div>
            <!-- end of content right -->


        </c:if>
        <!-- BOOK: end -->


        <div class="cleaner_with_height">&nbsp;</div>
    </div>
    <!-- PAGE CONTENT: end -->

    <div id="templatemo_footer">

        <a href="subpage.html">Home</a> | <a href="subpage.html">Search</a> | <a href="subpage.html">Books</a> | <a
            href="#">New Releases</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br/>
        Copyright © 2024 <a href="#"><strong>Your Company Name</strong></a>
        <!-- Credit: www.templatemo.com -->    </div>

</div> <!-- end of container -->

</body>
</html>