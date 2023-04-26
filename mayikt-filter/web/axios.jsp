<%--
  Created by IntelliJ IDEA.
  User: bitter清酒
  Date: 2022/11/15
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Axios</title>
    <%--1.引入axios类库--%>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script>
        function mayiktAxios(){
            <!--axios框架发送请求 -->
            alert("mayikt");
            // 1. 调用 axios 方法得到的返回值是 Promise 对象
            axios({
                // 请求方式
                method: 'GET',
                // 请求的地址
                url: 'http://localhost:8080/${pageContext.request.contextPath}/axiosServlet',
                // URL 中的查询参数
                params: {
                    name: "mayikt",
                    age : 22
                }
            }).then(function (result) {
                //发送请求成功之后
                alert(result.data)
                // console.log(result)
            })
        }
    </script>
</head>
<body>
<input type="button" value="发送ajax请求" onclick="mayiktAxios()">
</body>
</html>
