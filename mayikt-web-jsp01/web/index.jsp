<%--
  Created by IntelliJ IDEA.
  User: bitter清酒
  Date: 2022/11/9
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>电商项目</title>
  </head>
  <body>
  <h1>用户名称：{}</h1>
  <a href="https://jiadian.jd.com/">家用电器</a>
  <a href="https://shouji.jd.com/">手机数码</a>
  <a href="https://channel.jd.com/furniture.html">家居家电</a>
  <%
    System.out.println("我是定义在jspService方法之中");
    int j = 20;
    mayikt();
  %>

  <%="直接输出String类型"+j%>

  <%!
    void mayikt(){
      System.out.println("我是mayikt,我是定义在jspService()方法之外");
    }
    String userName = "mayikt";
  %>
  </body>
</html>
