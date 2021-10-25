<%--
  Created by IntelliJ IDEA.
  User: art
  Date: 12.10.21
  Time: 02:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Routes</title>
</head>
<body>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<table class="table table-striped">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Departure platform</th>
        <th scope="col">Arrival platform</th>
        <th scope="col">Train name</th>
        <th scope="col">Train type</th>
        <th scope="col">Departure date</th>
        <th scope="col">Arrival date</th>
        <th scope="col">Buy ticket</th>
    </tr>
    <c:forEach var="route" items="${routes}">
        <tr>
            <td><c:out value="${route.getId()}"/></td>
            <td><c:out value="${route.getDeparturePlatform().getCity()}"/></td>
            <td><c:out value="${route.getArrivalPlatform().getCity()}"/></td>
            <td><c:out value="${route.getTrain().getName()}"/></td>
            <td><c:out value="${route.getTrain().getType()}"/></td>
            <td><c:out value="${route.getDepartureDateTime()}"/></td>
            <td><c:out value="${route.getArrivalDateTime()}"/></td>
            <td><a type="button" class="btn btn-danger btn-link"
                        href="api?command=choose-seat&route=${route.getId()}">Buy ticket</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
