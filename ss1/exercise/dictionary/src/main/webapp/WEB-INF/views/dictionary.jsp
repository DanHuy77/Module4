<%--
  Created by IntelliJ IDEA.
  User: Nhật Huy
  Date: 11/18/2022
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ điển</title>
</head>
<body>
<form method="post" action="/search">
<input type="text" name="word" placeholder="Nhập từ cần tra">
<button type="submit">Search</button>
</form>
<p>${result}</p>
</body>
</html>
