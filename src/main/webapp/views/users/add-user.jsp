<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/26/2023
  Time: 1:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>">
  <input type="text" name="name" placeholder="nhap ten tai khoan" required>
  <input type="text" name="email" placeholder="nhap dia chi email" required>
  <input type="text" name="address" placeholder="nhap dia chi " required>
  <button type="submit">Add new</button>
</form>
</body>
</html>
