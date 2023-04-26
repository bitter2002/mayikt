package com.mayikt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.taglibs.standard.tag.common.core.ImportSupport;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/axiosServlet")
public class AxiosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet....");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost...");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        PrintWriter writer = resp.getWriter();
        writer.println(name+","+age);
        writer.close();
    }
}
