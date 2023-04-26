package com.mayikt.servlet;

import com.mayikt.entity.FlightEntity;
import com.mayikt.service.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/showFlight")
public class ShowFlightServlet extends HttpServlet {
    private FlightService flightService = new FlightService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用业务逻辑层获取数据
        List<FlightEntity> flightEntitys = flightService.getByAll();
        //转发到jsp中
        req.setAttribute("flights",flightEntitys);
        req.getRequestDispatcher("show.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
