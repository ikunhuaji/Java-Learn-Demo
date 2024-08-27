<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>

  <%
    for (int i = 0; i < 3; i++) {
  %>
    tmp<br>
  <%
    }
  %>
  <%= 2 + 3%><br>
  <%="2"+"3"%><br>
  <%="a"+"b"%><br>
  <% out.println("111"); %>

</body>
</html>