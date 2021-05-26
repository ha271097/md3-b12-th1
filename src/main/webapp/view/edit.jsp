<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 5/26/2021
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h1>Edit user</h1>
<form method="post">
    <table>
        <input type="hidden" name="id" value="${userOld.id}">
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name" value="${userOld.name}"></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><input type="text" name="email" value="${userOld.email}"></td>
        </tr>
            <td>Country: </td>
            <td><input type="text" name="country" value="${userOld.country}"></td>
        </tr>
    </table>
    <input type="submit" value="Update User">
</form>
</body>
</html>
