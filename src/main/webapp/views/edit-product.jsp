<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/25/2023
  Time: 3:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>">
    <input type="number" name="id" value="${pro.id}" readonly>
    <input type="text" name="name" value="${pro.name}" placeholder="nhap ten san pham" required>
    <input type="number" name="price" value="${pro.price}" placeholder="nhap gia tien" required>
    <input type="text" name="description" value="${pro.description}" placeholder="nhap mo ta san pham" required>
    <input type="text" name="producer" value="${pro.producer}" placeholder="nhap nha xuat ban" required>
    <button type="submit">Update</button>
</form>
</body>
</html>
