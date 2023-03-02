<%--
  Created by IntelliJ IDEA.
  User: 예병창
  Date: 2023-02-27
  Time: 오후 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>

<body>
<h1>회원가입페이지</h1>
<hr></hr>
<form action="/user/join.do" method="post" enctype="application/x-www-form-urlencoded">
    <input type="text" name="username" placeholder="Enter username" /><br/>
    <input type="text" name="password" placeholder="Enter password" /><br/>
    <input type="text" name="email" placeholder="Enter email" /><br/>
    <button type="submit">회원가입</button>
</form>
</body>
</html>
