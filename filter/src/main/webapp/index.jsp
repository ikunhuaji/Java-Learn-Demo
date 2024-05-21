<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<form action="login" method="post">
<%--    <input type="hidden" name="pageName" value="1"/>--%>
    <input type="text" name="username"/><br>
    <input type="password" name="pwd"/><br>
    <input type="submit" value="提交"/>
</form>

</body>
</html>