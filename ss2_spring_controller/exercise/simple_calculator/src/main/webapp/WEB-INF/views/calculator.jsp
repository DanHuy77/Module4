<%--
  Created by IntelliJ IDEA.
  User: Nhật Huy
  Date: 11/21/2022
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h1 style="text-align: center">Simple Calculator</h1>
<form action="/cal" method="post">
<p><span><input name="num1" type="number"></span> <span><input name="num2" type="number"></span></p>
<p>
    <span><button name="operator" value="+" type="submit">Addition(+)</button></span>
    <span><button name="operator" value="-" type="submit">Subtraction(-)</button></span>
    <span><button name="operator" value="x" type="submit">Multiplication(x)</button></span>
    <span><button name="operator" value="/" type="submit">Division(/)</button></span>
</p>
</form>

<p>${result}</p>
</body>
</html>
