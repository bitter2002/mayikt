package com.mayikt.servlet;

import com.mayikt.entity.MayiktUserEntity;
import com.mayikt.service.MayiktUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private MayiktUserService mayiktUserService = new MayiktUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //转发到login界面
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //点击登录是,获取用户参数
        String userName = req.getParameter("userName");
        if (StringUtils.isEmpty(userName)) {
            //转发到错误页面
            req.setAttribute("errorMsg", "userName不能够为空");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }
        String userPwd = req.getParameter("userPwd");
        if (StringUtils.isEmpty(userPwd)) {
            //转发到错误页面
            req.setAttribute("errorMsg", "userPwd不能够为空");
            req.getRequestDispatcher("error,jsp").forward(req, resp);
            return;
        }
        //在调用业务逻辑层
        MayiktUserEntity mayiktUserEntity = mayiktUserService.login(userName, userPwd);
        if (mayiktUserEntity == null) {
            //用户名称或密码错误
            req.setAttribute("errorMsg", "userName或userPwd错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        //判断 用户登入成功后,判断用户是否勾选记住密码,如果勾选,则将用户名和密码放入cookie中
        String rememberPassword = req.getParameter("rememberPassword");
        //勾选 rememberPassword为on  没勾选则为null
        if ("on".equals(rememberPassword)){
            //用户勾选的记住密码
            Cookie userNameCookie = new Cookie("userName", userName);
            userNameCookie.setMaxAge(60*60*24*7);//cookie的有效值为七天
            Cookie userPwdCookie = new Cookie("userPwd", userPwd);
            userPwdCookie.setMaxAge(60*60*24*7);
            //将该cookie数据返回客户端
            resp.addCookie(userNameCookie);
            resp.addCookie(userPwdCookie);
        }
        //能在db中查找到对象,登入成功了,将用户的数据存入session中
        HttpSession session = req.getSession();
        session.setAttribute("user",mayiktUserEntity);
        //在重定向到首页
        resp.sendRedirect("index.jsp");
//        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
