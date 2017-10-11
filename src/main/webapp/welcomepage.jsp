
<%@ page import="java.util.*"%>

<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>One result page for all queries</title>
</head>
<body>

<%String username = (String) request.getAttribute("username");%>
<B><%="Welcome" + username%></B>
<a href="index.jsp">Go to Home Page</a>

</body>
</html>