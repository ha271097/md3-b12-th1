<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 5/27/2021
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Search User</title>
</head>
<body>
<h1>User By Country</h1>
<table border="1">
    <tr><td>ID: </td>
        <td>Name: </td>
        <td>Email: </td>
        <td>Country: </td>
    </tr>
    <c:forEach items="${listUserByCountry}" var="listUBC">
        <tr>
            <td>${listUBC.getId()} </td>
            <td>${listUBC.getName()} </td>
            <td>${listUBC.getEmail()}</td>
            <td>${listUBC.getCountry()}</td>
        </tr>
    </c:forEach>
    <a href="/user?action=">Back Home</a>
</table>
</body>
</html>
