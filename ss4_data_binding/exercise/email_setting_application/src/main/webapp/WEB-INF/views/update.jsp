<%--
  Created by IntelliJ IDEA.
  User: Nhật Huy
  Date: 11/22/2022
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Setting</title>
</head>
<body>

<form:form action="/update" method="post" modelAttribute="emailSettings">
    <pre>Languages    <form:select path="language" items="${language}"/></pre>
    <pre>Page Size    Show <form:select path="pageSize" items="${pageSize}"/> emails per page</pre>
    <pre>Spams Filter <form:checkbox path="spamFilter" value="true"/> Enable spams filter</pre>
    <pre>Signature    <form:textarea path="signature"/></pre>
<span><button type="submit">Update</button></span></form:form> <span><a href="/setting"><button>Cancel</button></a></span>
</body>
</html>
