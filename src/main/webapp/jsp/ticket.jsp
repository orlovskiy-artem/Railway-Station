<%--
  Created by IntelliJ IDEA.
  User: art
  Date: 28.09.21
  Time: 02:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action=${pageContext.request.contextPath}/buy-ticket method="post">
  <div class="card">

    <div class="card-body">

      <div class="form-group">
        <label>Your name</label>
        <input type="text" class="form-control" name="name" value="${currentUser.name}"placeholder="name"
               readonly/>


      </div>

      <div class="form-group">
        <label>Your surname</label>
        <input type="text" class="form-control" name="surname" value="${currentUser.surname}" placeholder="surname"
               readonly/>
      </div>

      <div class="form-group">
        <label>Enter departure date:</label>
        <input type="date" class="form-control form-control" name="departureDate"
               min="${currentDate}" max="${currentDatePlusMonth}"/>
      </div>

      <div class="form-group">
        <label>Enter wagon</label>
        <input type="number" class="form-control" name="wagonNumber"  placeholder="wagon"
               min="1" max="${currentTrain.wagonsQuantity}"/>
      </div>

      <div class="form-group">
        <label>Enter place</label>
        <input type="number" class="form-control" name="placeNumber"  placeholder="place"
               min="1" max="${currentTrain.placesQuantity}"/>
      </div>

    </div>

    <div class="card-footer">
      <input type="submit" value="Buy" class="btn btn-primary"/>
    </div>

  </div>
</form>
</body>
</html>
