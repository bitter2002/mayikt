
package com.mayikt.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author 余胜军
 * @ClassName UserSessionFilter
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@WebFilter("/*")// 过滤器所有的请求
public class UserSessionFilter implements Filter {
    private String[] excludeUrls = new String[]{"/login", "/register", "/VerifycodeServlet","/exUserName,","/registerAjax","/ajaxRegister.jsp"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 从session获取到用户的会话信息 判断用户是否登录过
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //获取当前项目名称
        String contextPath = httpServletRequest.getContextPath();
        // 定义一个数组 哪些 请求是需要排除的
        for (int i = 0; i < excludeUrls.length; i++) {
            String excludeUrl = contextPath + excludeUrls[i];
            String requestURI = httpServletRequest.getRequestURI();
            if (excludeUrl.equals(requestURI)) {
                // 放行请求
                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }
        }
        // 排除请求
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            // 当前用户没有登录或者登录会话失效
            // 重定向到登录页面
            httpServletResponse.sendRedirect("/mayikt_session_war_exploded/login");
            return;
        }
        // 用户已经登录了 正常放行请求
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}