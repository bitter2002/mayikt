package com.mayikt.servlet;

import com.mayikt.entity.MayiktUserEntity;
import com.mayikt.service.MayiktUserService;
import com.mayikt.utils.RandomValidateCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private MayiktUserService mayiktUserService = new MayiktUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //转发到register.jsp
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        if (StringUtils.isEmpty(userName)) {
            req.setAttribute("errorMsg", "userName不能够为空");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        String userPwd = req.getParameter("userPwd");
        if (StringUtils.isEmpty(userPwd)) {
            req.setAttribute("errorMsg", "userPwd不能够为空");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        //比较图形验证码
        String userCode = req.getParameter("code");//用户输入的图形验证码
        //从session中获取验证码
        HttpSession session = req.getSession();
        String sessionCode = (String) session.getAttribute(RandomValidateCode.MAYIKT_RANDOMVALIDATECODE);
        if (!sessionCode.equalsIgnoreCase(userCode)){
            req.setAttribute("errorMsg", "图形验证码不正确");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }
        //用户数据注册
        MayiktUserEntity dbmayiktUserEntity = mayiktUserService.findByUserName(userName);
        if(dbmayiktUserEntity!=null){
            req.setAttribute("errorMsg","用户已被注册");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }
        int register = mayiktUserService.register(userName, userPwd);
        if (register <= 0) {
            //注册失败
            req.setAttribute("errorMsg","注册失败");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }
        //注册成功重定向到登入请求
        resp.sendRedirect("login.jsp");
    }
}
