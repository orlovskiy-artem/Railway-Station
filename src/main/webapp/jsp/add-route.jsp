<%--
  Created by IntelliJ IDEA.
  User: Art Orl
  Date: 10/26/2021
  Time: 12:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add route</title>
</head>
<body>
<%@ page import="com.kpi.railwaystation.model.BasicTrainRoute" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
Get routes for this places:
<form action="api" method="POST">
    <input type="hidden" name="command" value="add-route">
    <div class="form-group">
        <label for="departure-platform-id">Departure Platform</label>
        <input type="text" class="form-control" name="departure-platform" id="departure-platform-id">
    </div>
    <div class="form-group">
        <label for="arrival-platform-id">Arrival Platform</label>
        <input type="text" class="form-control" name="arrival-platform" id="arrival-platform-id">
    </div>
    <div class="form-group">
        <label for="train-id">Train</label>
        <input type="text" class="form-control" name="train" id="train-id">
    </div>
    <div class="form-group">
        <label for="departure-datetime-id">Departure Datetime</label>
        <input type="text" class="date" name="departure-datetime"
               id="departure-datetime-id"
               value = "<fmt:formatDate  pattern="HH:mm dd-MM-yyyy"/>">
    </div>
    <div class="form-group">
        <label for="arrival-datetime-id">Arrival Datetime</label>
        <input type="text" class="date" name="arrival-datetime"
               id="arrival-datetime-id"
               value = "<fmt:formatDate pattern="HH:mm dd-MM-yyyy"/>">
    </div>
    <input class="btn btn-primary" type="submit" value="Add route">
</form>
</body>
</html>
