<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 5/26/2021
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<h1>Create New User</h1>
<form method="post">
<table>
    <tr>
        <td>Name: </td>
        <td><input type="text" name="name" placeholder="Enter Name"></td>
    </tr>
    <tr>
        <td>Email: </td>
        <td><input type="text" name="email" placeholder="Enter Email"></td>
    </tr>
       <tr>
           <td>Country: </td>
           <td> <input type="text" name="country" placeholder="Enter Country"></td>

       </tr>
</table>
    <input type="submit" value="Add User">
</form>
</body>
</html>
