<%--
  Created by IntelliJ IDEA.
  User: bitter清酒
  Date: 2022/11/9
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--${age}--%>
<%--<c:if test="${age>18}">--%>
<%--  <h1>年龄大于18</h1>--%>
<%--</c:if>--%>
<%--<c:if test="${age<18}">--%>
<%--  <h1>年龄小于18</h1>--%>
<%--</c:if>--%>
<%--<c:if test="${age==18}">--%>
<%--  <h1>年龄等于18</h1>--%>
<%--</c:if>--%>
<table border="1" align="center" style="border-collapse: collapse;width: 30%">
    <tr align="center">
        <th align="center">序号</th>
        <th align="center">名称</th>
        <th align="center">年龄</th>
        <th align="center">冻结</th>
        <th align="center">操作</th>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="m">
        <tr align="center">
            <td align="center">${m.index+1}</td>
            <td align="center">${user.userName}</td>
            <td align="center">${user.age}</td>
            <td align="center">
                <c:if test="${user.state=='1'}">冻结</c:if>
                <c:if test="${user.state=='0'}">未冻结</c:if>
            </td>
            <td align="center"><a href="#">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

