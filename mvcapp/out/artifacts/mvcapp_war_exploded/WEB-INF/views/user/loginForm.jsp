<%--
  Created by IntelliJ IDEA.
  User: 예병창
  Date: 2023-02-27
  Time: 오후 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>로그인</title>
</head>
<body>
<h1>로그인페이지</h1>
<hr></hr>
<form action="/user/login.do" method="post" enctype="application/x-www-form-urlencoded">
    <input type="text" name="username" placeholder="Enter username" /><br/>
    <input type="text" name="password" placeholder="Enter password" /><br/>
    <button type="submit">로그인</button>




</form>
</body>
</html>