<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/26/2023
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="users?action=add">Them moi user</a>
<form action="users">
    <input type="text" name="search" value="${searchName}">
    <input type="submit" name="action" value="search">
</form>
<table border="1" cellspacing="0">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="item" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.email}</td>
            <td>${item.address}</td>
            <td><a href="/users?action=edit&id=${item.id}">Edit</a></td>
            <td><a href="/users?action=delete&id=${item.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
