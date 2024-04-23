<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br>
<%
    String name = "";
    Cookie[] cookies = request.getCookies();
    if(cookies!=null)
    {
        for(Cookie cookie:cookies){
            //System.out.println(cookie.getName() + " " + cookie.getValue());
            if(cookie.getName()=="un"){
                name=cookie.getValue();
            }
        }
    }
%>

    <form action="login" method="post">
        用户名：<input type="text" name="username" value="<%=name%>"><br>
        密码：<input type="password" name="pwd"><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>