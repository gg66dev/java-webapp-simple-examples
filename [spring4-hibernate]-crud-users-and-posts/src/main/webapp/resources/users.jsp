<%--
  Created by IntelliJ IDEA.
  User: Gustavo Pfeifer
  Date: 02/05/2017
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users<h1>

    <c:forEach items="${users}" var="user">
        ${user.name}<br>
    </c:forEach>

</body>
</html>
