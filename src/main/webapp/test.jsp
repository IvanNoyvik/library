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

<form method="post" action="<c:url value="/test"/>"
      enctype="multipart/form-data">

    Select file to upload:
    <br />
    <input type="file" name="file" accept="image/*"  />
    <br />
    <br />
    <br />
    <label>    Description:
        <input type="text" name="description" size="100" />
    </label>
    <br />
    <br />
    <input type="submit" value="Upload" />
</form>


<br>
<br>
</body>
</html>
