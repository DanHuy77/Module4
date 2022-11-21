<%--
  Created by IntelliJ IDEA.
  User: Nhật Huy
  Date: 11/21/2022
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách gia vị</title>
</head>
<body>
<p>${message}</p>
<table style="border: solid 1px">
    <tr>
        <th>Số thứ tự</th>
        <th>Tên bánh</th>
        <th>Gia vị</th>
        <th>Thêm gia vị</th>
    </tr>
    <c:forEach var="sandwich" items="${sandwichList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${sandwich.getName()}</td>
            <td>${sandwich.getCondiments()}</td>
            <td><a href="/add/${sandwich.id}"><button>Thêm gia vị</button></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
