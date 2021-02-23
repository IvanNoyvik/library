<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    <%@include file='/WEB-INF/static/main/templatemo_style.css' %>
</style>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Book Store Template, Free CSS Template, CSS Website Layout</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<c:url value="/WEB-INF/static/main/templatemo_style.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
<!--  Free CSS Templates from www.templatemo.com -->
<div id="templatemo_container">
    <div id="templatemo_menu">
        <ul>

            <!-- LOGIN -->
            <li><a href="login.html" class="current">Login</a></li>

            <!-- LOGOUT -->
            <li><a href="logout.html" class="current">Logout</a></li>

            <!-- REGISTR -->
            <li><a href="<c:url value="/WEB-INF/jsp/registration2.jsp"/> " class="current">Registration</a></li>

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
                    <li><a href="http://www.photovaco.com" target="_parent">Free Photos</a></li>
                </ul>
            </div>

            <div class="templatemo_content_left_section">
                <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
                <a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
            </div>
        </div>
        <!-- CATEGORY FILTER: end -->

        <div id="templatemo_content_right">

            <!-- BOOK: start -->
            <div class="templatemo_product_box">

                <h1>Photography  <span>(by Best Author)</span></h1>

                <img src="/WEB-INF/static/main/images/templatemo_image_01.jpg" alt="image" />

                <div class="product_info">
                    <p>Etiam luctus. Quisque facilisis suscipit elit. Curabitur...</p>
                    <h3>$55</h3>
                    <div class="buy_now_button"><a href="subpage.html">Buy Now</a></div>
                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
                </div>

            </div>

            <!-- Insert empty string after book -->
            </br>

            <!-- BOOK: end -->

            <a href="subpage.html"><img src="/WEB-INF/static/main/images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->

        <div class="cleaner_with_height">&nbsp;</div>
    </div>
    <!-- PAGE CONTENT: end -->

    <div id="templatemo_footer">

        <a href="subpage.html">Home</a> | <a href="subpage.html">Search</a> | <a href="subpage.html">Books</a> | <a href="#">New Releases</a> | <a href="#">FAQs</a> | <a href="#">Contact Us</a><br />
        Copyright © 2024 <a href="#"><strong>Your Company Name</strong></a>
        <!-- Credit: www.templatemo.com -->    </div>
    <!-- end of footer -->
    <!--  Free CSS Template www.templatemo.com -->
</div> <!-- end of container -->
<!-- templatemo 086 book store -->
<!--
Book Store Template
http://www.templatemo.com/preview/templatemo_086_book_store
-->
</body>
</html>