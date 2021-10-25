<%@ page import="com.kpi.railwaystation.model.BasicTrainRoute" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: art
  Date: 12.10.21
  Time: 02:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Search routes</title>
</head>
<body>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
Get routes for this places:
<form action="api" method="POST">
    <input type="hidden" name="command" value="search-routes">
    <div class="form-group">
        <label for="departure-city-id">Departure City</label>
        <input type="text" class="form-control" name="departure-city" id="departure-city-id" placeholder="Kyiv">
    </div>
    <div class="form-group">
        <label for="arrival-city-id">Arrival City</label>
        <input type="text" class="form-control" name="arrival-city" id="arrival-city-id" placeholder="Lviv">
    </div>
    <input class="btn btn-primary" type="submit" value="Search routes">
</form>
</body>
</html>
