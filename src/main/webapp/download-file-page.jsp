<%--
  Created by IntelliJ IDEA.
  User: yauhenav
  Date: 16.6.18
  Time: 20.14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<html>
<head>
    <title>Result of one file query</title>
</head>
<body>
<p>Here come all the images from the DB with their width being set to 128 pixels:</p>
<c:forEach var="image" begin = "1" end = "20">
    <img src="${pageContext.request.contextPath}/manage?id=${image}" style="width:128px;height:128px;">
</c:forEach>

</body>
</html>
