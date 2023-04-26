package com.mayikt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns ="/servletconfig",initParams = {
        @WebInitParam(name="p1",value="mayikt")
})
public class ServletConfigServlet implements Servlet {
    private ServletConfig servletConfig;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        String p1 = servletConfig.getInitParameter("p1");
        System.out.println(p1);//mayikt
        this.servletConfig = servletConfig;
    }
/*
*
* 在我们Servlet其他的方法需要根据ServletConfig获取初始化参数值
* */
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String p1 = getServletConfig().getInitParameter("p1");
        PrintWriter writer = servletResponse.getWriter();
        writer.println(p1);
        writer.close();
    }

    @Override
    public String getServletInfo() {
        return "me is luoyaozhong";
    }

    @Override
    public void destroy() {

    }
}
