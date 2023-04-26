<%--
  Created by IntelliJ IDEA.
  User: bitter清酒
  Date: 2022/11/14
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录测试页面</title>
    <form action="/mayikt_session_war_exploded/login" method="post">
        <label>用户名: </label><input type="text" name="userName" value="${cookie.userName.value}"/><br>
        <label>密&nbsp码&nbsp: </label><input type="password" name="userPwd" value="${cookie.userPwd.value}"/><br>
        <label>记住密码: </label><input type="checkbox" name="rememberPassword"/><br>
        ${errorMsg}
        <input type="submit" value="登录 "/>
    </form>
</head>
<body>

</body>
</html>
