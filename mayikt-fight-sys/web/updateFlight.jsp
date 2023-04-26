<%--
  Created by IntelliJ IDEA.
  User: bitter清酒
  Date: 2022/11/10
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改航班信息</title>
</head>
<body>
<div>
    <h1>修改数据</h1>

    <form action="updateFlight" method="post">
        <input type="hidden" value="${flight.id}" name="id">
        <label>航&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:&nbsp;<input type="text" value="${flight.flightId}" name="flightId"></label><br>
        <label>航空公司:&nbsp;<input type="text" value="${flight.company}" name="company"></label><br>
        <label>出发机场:&nbsp;<input type="text" value="${flight.departureAirport}" name="departureAirport"></label><br>
        <label>达到机场:&nbsp;<input type="text" value="${flight.arriveAirport}" name="arriveAirport"></label><br>
        <label>出发时间:&nbsp;<input type="text" value="${flight.departureTime}" name="departureTime"></label><br>
        <label>到达时间:&nbsp;<input type="text" value="${flight.arriveTime}" name="arriveTime"></label><br>
        <label>机&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型:&nbsp;<input type="text" value="${flight.model}" name="model"></label><br>
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
