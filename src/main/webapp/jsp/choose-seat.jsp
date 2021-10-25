<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Art Orl
  Date: 10/25/2021
  Time: 2:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Seats</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<table class="table table-striped">
    <tr>
        <c:forEach begin="1" end="${numberOfSeatsHalved}" varStatus="loop">
            <td>
                <a type="button" class="btn btn-danger btn-link"
                   href="api?command=buy-ticket&seat=${seats[loop.index-1].getId()}&route=${route.getId()}">${loop.index}</a>
            </td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach begin="${1+numberOfSeatsHalved}" end="${numberOfSeats}" varStatus="loop">
            <td>
                <a type="button" class="btn btn-danger btn-link"
                   href="api?command=buy-ticket&seat=${seats[loop.index-1].getId()}&route=${route.getId()}">${loop.index}</a>
            </td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
