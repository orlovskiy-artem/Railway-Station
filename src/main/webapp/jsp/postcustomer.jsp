<%--
  Created by IntelliJ IDEA.
  User: art
  Date: 28.09.21
  Time: 03:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CustomerForm</title>
</head>
<body>
<form action="post-user" method="POST">
  Firstname: <input name="firstName" />
  <br><br>
  Lastname: <input name="lastName" />
  <br><br>
  Email: <input name="email" />
  <br><br>
  Password: <input name="password" type="password"/>
  <br><br>
  <input type="submit" value="Submit" />
</form>
</body>
</html>
