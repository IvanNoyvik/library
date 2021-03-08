<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.03.2021
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TEST</title>
</head>
<body>

<h2>Upload Files</h2>

<form method="post" action="<c:url value="/test"/>" enctype="multipart/form-data">

    <input type="file" name="file" accept="image/*"  />
    <input type="hidden" name="id" value="${requestScope.book.id}"  />

    <input type="submit" value="Upload" />
</form>

<c:url value="/test2" var="profile" >
    <c:param name="id" value="${requestScope.book.id}"/>
</c:url>

<c:if test="${!empty requestScope.book.image}">
    <div >
        <img src="${profile}" alt="CSS Template" width="100"
             height="150"/>
    </div>
</c:if>
<c:if test="${empty requestScope.book.image}">
    <div >
        <img src="<c:url value="/static/main/images/no_image.png" />" alt="CSS Template" width="150"
             height="150"/>
    </div>
</c:if>

<br>
<br>
</body>
</html>
