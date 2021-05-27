<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 5/26/2021
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Show ALL User</title>
</head>
<body>
<h1>All Users</h1>
<td><a href="/user?action=create">Add User</a></td>
<form method="get">
    <table border="1">
        <tr>
            <td>ID: </td>
            <td>Name: </td>
            <td>Email: </td>
            <td>Country: </td>
            <td>Edit User: </td>
            <td>Delete User: </td>
        </tr>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.id} </td>
                <td>${u.name} </td>
                <td>${u.email}</td>
                <td>${u.country}</td>
                <td><a href="/user?action=edit&id=${u.id}">Edit</a></td>
                <td><a href="/user?action=delete&id=${u.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
<h1>Search User</h1>
<form method="post" action=user>
    <input type="text" name="country" placeholder="Enter country">
    <input type="submit" value="search" name="action">
</form>
</body>
</html>
