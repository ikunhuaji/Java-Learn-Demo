<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<a href="hello">查看请求头</a>
<form action="login" method="post">
    <h1>聊天室</h1><br>
    账号：<input type="text" name="username"><br>
    <%
        Object obj = request.getAttribute("errorinfo");
        if(obj!=null){
            out.print(obj);
        }
    %>
    <br><input type="submit" value="提交">
</form>
</body>
</html>