package com.mayikt.servlet;

import com.alibaba.fastjson.JSONObject;
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
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/registerAjax")
public class RegisterAjaxServlet extends HttpServlet {
    private MayiktUserService mayiktUserService = new MayiktUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //转发到register.jsp
        req.getRequestDispatcher("ajaxRegister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String userName = req.getParameter("userName");
        if (StringUtils.isEmpty(userName)) {
            setResultError("userName不能为空",writer);
            return;
        }
        String userPwd = req.getParameter("userPwd");
        if (StringUtils.isEmpty(userPwd)) {
//            req.setAttribute("errorMsg", "userPwd不能够为空");
//            req.getRequestDispatcher("register.jsp").forward(req, resp);
            setResultError("userPwd不能为空",writer);
            return;
        }
        //比较图形验证码
        String userCode = req.getParameter("code");//用户输入的图形验证码
        //从session中获取验证码
        HttpSession session = req.getSession();
        String sessionCode = (String) session.getAttribute(RandomValidateCode.MAYIKT_RANDOMVALIDATECODE);
        if (StringUtils.isEmpty(sessionCode)){
            setResultError("请加载图形验证码",writer);
            return;
        }
        if (!sessionCode.equalsIgnoreCase(userCode)){
//            req.setAttribute("errorMsg", "图形验证码不正确");
//            req.getRequestDispatcher("register.jsp").forward(req, resp);
         setResultError("图形验证码不正确,请重新输入",writer);
        }
        //用户数据注册
        MayiktUserEntity dbmayiktUserEntity = mayiktUserService.findByUserName(userName);
        if(dbmayiktUserEntity!=null){
//            req.setAttribute("errorMsg","用户已被注册");
//            req.getRequestDispatcher("register.jsp").forward(req,resp);
            setResultError("该用户"+userName+"在数据库中存在无法重复注册",writer);
            return;
        }
        int register = mayiktUserService.register(userName, userPwd);
        if (register <= 0) {
            //注册失败
//            req.setAttribute("errorMsg","注册失败");
            setResultError("注册失败",writer);
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }
        //注册成功重定向到登入请求
//        resp.sendRedirect("login.jsp");
        setResultOk("注册成功",writer);
    }
    public void setResultError(String msg,PrintWriter writer){
       setResult(500,msg,writer);
    }
    public void setResultOk(String msg,PrintWriter writer){
     setResult(200,msg,writer);
    }
    public void setResult(Integer code,String msg,PrintWriter writer){
        HashMap<String, Object> result = new HashMap<>();
        result.put("code",code);
        result.put("msg",msg);
        String jsonStr = JSONObject.toJSONString(result);
        writer.println(jsonStr);
        writer.close();
    }
}
