<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/25/2023
  Time: 1:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="product?action=add">Them moi san pham</a>
<table border="1" cellspacing="0">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>producer</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="item" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.description}</td>
            <td>${item.producer}</td>
            <td><a href="/product?action=edit&id=${item.id}">Edit</a></td>
            <td><a href="/product?action=delete&id=${item.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
