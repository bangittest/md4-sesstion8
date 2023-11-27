<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/26/2023
  Time: 2:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>">
    <input type="text" name="id" value="${useList.id}"  readonly>
  <input type="text" name="name" value="${useList.name}" >
  <input type="text" name="email" value="${useList.email}" >
  <input type="text" name="address" value="${useList.address}" >
  <button type="submit">Add new</button>
</form>
</body>
</html>
