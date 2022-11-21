<%--
  Created by IntelliJ IDEA.
  User: Nhật Huy
  Date: 11/21/2022
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm gia vị</title>
</head>
<body>


<form action="/add" method="post">
    <input type="checkbox" name="condiments" value=" Lettuce">Lettuce
    <input type="checkbox" name="condiments" value=" Tomato">Tomato
    <input type="checkbox" name="condiments" value=" Mustard">Mustard
    <input type="checkbox" name="condiments" value=" Sprouts">Sprouts
    <input hidden name="id" value="${sandwich.id}">
    <button type="submit">Confirm</button>
</form>
</body>
</html>
