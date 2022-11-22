<%--
  Created by IntelliJ IDEA.
  User: Nhật Huy
  Date: 11/22/2022
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h1>Setting</h1>
<p>${message}</p>
<table>
    <tr>
        <td>Language: </td>
        <td>${emailSettings.language}</td>
    </tr>
    <tr>
        <td>Page Size: </td>
        <td>${emailSettings.pageSize}</td>
    </tr>
    <tr>
        <td>Spam Filter: </td>
        <c:if test="${emailSettings.spamFilter == false}">
            <td>Off</td>
        </c:if>
        <c:if test="${emailSettings.spamFilter == true}">
            <td>On</td>
        </c:if>
    </tr>
    <tr>
        <td>Signature: </td>
        <td><textarea>${emailSettings.signature}</textarea></td>
    </tr>
</table>
<a href="/update"><button>Edit</button></a>
</body>
</html>
