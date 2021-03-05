<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Edit Book</title>
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
                <c:if test="${!empty requestScope.message}">
                    You have successfully registered!
                </c:if>
            </p>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>


        <div id="templatemo_new_books">
            <c:if test="${sessionScope.user.role.role eq 'Administrator'}">
                <%--                <form action="<c:url value="/front"/>" method="post" >--%>
                <%--                    <input type="hidden" name="command" value="Forward"/>--%>
                <%--                    <input type="hidden" name="forward" value="editBook"/>--%>
                <%--                    <h1><input type="submit" value="Edit book"/></h1>--%>
                <%--                </form>--%>
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
            <form action="<c:url value="/front"/>" method="post">

                <div id="templatemo_content_right">

                    <h1><label>Title: </label>
                        <input name="title" required type="text" value="${requestScope.book.title}"/>
                    </h1>

                    <div class="image_panel">

                        <c:if test="${!empty requestScope.book.image}">
                            <img src="<c:url value="${requestScope.book.image}" />" alt="CSS Template" width="100"
                                 height="150"/>
                        </c:if>
                        <c:if test="${empty requestScope.book.image}">
                            <img src="<c:url value="/static/main/images/no_image.png" />" alt="CSS Template" width="150"
                                 height="150"/>
                        </c:if>
                    </div>

                    <div class="product_info">

                        <label> Genre (${requestScope.book.genre.genre}):
                            <select>
                                <c:forEach items="${requestScope.genres}" var="genre">
                                    <c:if test="${genre eq requestScope.book.genre}">
                                        <option selected="selected" value="${genre.genre}">${genre.genre}</option>
                                    </c:if>
                                    <c:if test="${genre ne requestScope.book.genre}">
                                        <option value="${genre.genre}">${genre.genre}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </label>
                        <br/>

                        <label> Author (${requestScope.book.author.author}):
                            <select>
                                <c:forEach items="${requestScope.authors}" var="author">
                                    <c:if test="${author eq requestScope.book.author}">
                                        <option selected="selected" value="${author.author}">${author.author}</option>
                                    </c:if>
                                    <c:if test="${author ne requestScope.book.author}">
                                        <option value="${author.author}">${author.author}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </label>
                        <br/>
                        <label>Quantity:
                        <input name="quantity" required type="text"
                               value="${requestScope.book.quantity}"/></label>


                        <textarea name="context" cols="30" rows="5" >${book.description}</textarea><br/>


                        <div class="buy_now_button"><a href="subpage.html">Read</a></div>
                        <div class="detail_button"><a href="subpage.html">Detail</a></div>
                    </div>

                    <div class="cleaner_with_height">&nbsp;</div>


                </div>
                <!-- end of content right -->

            </form>

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