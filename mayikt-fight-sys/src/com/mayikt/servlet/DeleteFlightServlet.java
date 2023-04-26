package com.mayikt.servlet;

import com.mayikt.service.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteFlight")
public class DeleteFlightServlet extends HttpServlet {
    private FlightService flightService = new FlightService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据主键id删除航班信息
        //获取jsp传递id值
        String idStr = req.getParameter("id");
        if (idStr == null || idStr == "") {
            //跳转到错误页面
            req.setAttribute("errorMsg", "id的值为空");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }
        try {
            Integer id = Integer.parseInt(idStr);
            int result = flightService.deleteFlightById(id);
            //如果删除成功的情况下,则重定向到show查询航班信息
            if (result > 0) {
//                req.getRequestDispatcher("showFlight").forward(req, resp);
                resp.sendRedirect("showFlight");
            }else {
                req.setAttribute("errorMsg", "删除失败");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
            //如果删除失败,则跳转到错误界面
        } catch (NumberFormatException e) {
            //类型转换异常
            e.printStackTrace();
            //错误转发到jsp页面
            req.setAttribute("errorMsg", "类型转换异常,id的值无法转换成int类型");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("errorMsg", "系统异常");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
