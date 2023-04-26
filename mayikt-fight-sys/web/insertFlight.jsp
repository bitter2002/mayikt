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
    <title>插入航班信息</title>
</head>
<body>
<div>
    <h1>修改数据</h1>

    <form action="insertFlight" method="post">
        <label>航&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:&nbsp;<input type="text" name="flightId"></label><br>
        <label>航空公司:&nbsp;<input type="text"  name="company"></label><br>
        <label>出发机场:&nbsp;<input type="text" name="departureAirport"></label><br>
        <label>达到机场:&nbsp;<input type="text" name="arriveAirport"></label><br>
        <label>出发时间:&nbsp;<input type="text" name="departureTime"></label><br>
        <label>到达时间:&nbsp;<input type="text" name="arriveTime"></label><br>
        <label>机&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型:&nbsp;<input type="text" name="model"></label><br>
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
