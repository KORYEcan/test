<%--
  Created by IntelliJ IDEA.
  User: 예병창
  Date: 2023-02-27
  Time: 오후 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
<h1>게시글 쓰기</h1>
</hr>
<form action="/board/save.do" method="post" enctype="application/x-www-form-urlencoded">
  <input type="text" name="title" placeholder="Enter title" /><br/>
  <input type="text" name="content" placeholder="Enter content" /><br/>
  <button type="submit">글쓰기 완료</button>
</form>
</body>
</html>
