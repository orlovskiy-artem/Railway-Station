<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div class="container">
    <h1><%= "Railway station" %></h1>
    <a>Welcome to the main menu!</a>
    <a href="api?command=search-routes">Search routes</a>
    <a href="api?command=add-route">Add routes</a>
</div>
</body>
</html>