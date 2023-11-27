<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/25/2023
  Time: 2:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>">
    <input type="text" name="name" placeholder="nhap ten san pham" required>
    <input type="number" name="price" placeholder="nhap gia tien" required>
    <input type="text" name="description" placeholder="nhap mo ta san pham" required>
    <input type="text" name="producer" placeholder="nhap nha xuat ban" required>
    <button type="submit">Add new</button>
</form>
</body>
</html>
