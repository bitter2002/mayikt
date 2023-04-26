package com.mayikt.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public abstract class MayiktHttpServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
      HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)){
            doGet(httpServletRequest);
        }else if ("POST".equals(method)){
            doPost(httpServletRequest);
        }
    }
    protected void doPost(HttpServletRequest httpServletRequest) {
    }

    protected void doGet(HttpServletRequest httpServletRequest) {

    }
}
