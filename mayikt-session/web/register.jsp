<%--
  Created by IntelliJ IDEA.
  User: bitter清酒
  Date: 2022/11/14
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <form action="/mayikt_session_war_exploded/register" method="post">
        <label>用户名: </label><input type="text" name="userName" onkeyup="onkeyup(mayiktAxios(this))"/><br>
        <label>密&nbsp&nbsp&nbsp码: </label><input type="password" name="userPwd"/><br>
        <label>验证码: </label><input type="text" name="code"/><img id="exchangecode" src="VerifycodeServlet">
        <a id="ecode" href="#">看不清？换一张图片</a><br>
        <span id="error" style="color: red">${errorMsg}</span>
        <input type="submit" value="注册"/>
    </form>
    <script type="text/javascript">
        window.onload = function () {
            //获取img标签的对象
            img = document.getElementById("exchangecode");
            img.onclick = function () {
                //加时间戳,避免浏览器缓存
                var date = new Date().getTime()
                img.src = "VerifycodeServlet?" + date;
            }
            //获取a标签的对象
            ec = document.getElementById("ecode");
            ec.onclick = function () {
                //加时间戳
                var date = new Date().getTime()
                img.src = "VerifycodeServlet?" + date;
            }
        }

    </script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script>
        function mayiktAxios(object){
            //接收用户输入的userName
            var userName = object.value;
            //2.使用Axios发送ajax请求验证userName是否存在
            // 1. 调用 axios 方法得到的返回值是 Promise 对象
            axios({
                // 请求方式
                method: 'GET',
                // 请求的地址
                url: 'http://localhost:8080${pageContext.request.contextPath}/exUserName',
                // URL 中的查询参数
                params: {
                    userName: userName,
                }
            }).then(function (result) {
                //定位到span id名称
                document.getElementById("error").innerText=result.data
            })
        }
    </script>
</head>
<body>

</body>
</html>
