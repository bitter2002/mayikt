package com.mayikt.servlet;

import com.mayikt.dao.FlightDao;
import com.mayikt.entity.FlightEntity;
import com.mayikt.service.FlightService;
import com.mayikt.utils.DateUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Date;

@WebServlet("/updateFlight")
public class UpdateFlightServlet extends HttpServlet {
    private FlightService flightService = new FlightService();

    /*
     * doGet用户点击修改该条数据--需要查询到该条数据(回显)
     * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取需要修改id的值
        String idStr = req.getParameter("id");
        if (idStr == null || idStr == "") {
            //跳转到错误页面
            req.setAttribute("errorMsg", "id的值为空");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }
        try {
            Integer id = Integer.parseInt(idStr);
            FlightEntity flightEntity = flightService.getByIdFlight(id);
            if (flightEntity == null) {
                //转发到错误jsp
                req.setAttribute("errorMsg", "id在数据库中无法查询数据");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
            //转发到修改航班信息页面
            req.setAttribute("flight", flightEntity);
            req.getRequestDispatcher("updateFlight.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("errorMsg", "系统错误");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    /*
     *doPost接收用户需要修改的数据
     * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //参数验证
            String idStr = req.getParameter("id");
            if (StringUtils.isEmpty(idStr)) {
                req.setAttribute("errorMsg", "id值不能为空");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
            Integer id = Integer.parseInt(idStr);
            String flightId = req.getParameter("flightId");
            if (StringUtils.isEmpty(flightId)) {
                req.setAttribute("errorMsg", "id值不能为空");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
            String company = req.getParameter("company");
            if (StringUtils.isEmpty(company)) {
                req.setAttribute("errorMsg", "company值不能为空");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
            String departureAirport = req.getParameter("departureAirport");
            if (StringUtils.isEmpty(departureAirport)) {
                req.setAttribute("errorMsg", "departureAirport值不能为空");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
            String arriveAirport = req.getParameter("arriveAirport");
            if (StringUtils.isEmpty(arriveAirport)) {
                req.setAttribute("errorMsg", "arriveAirport值不能为空");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
            //将日期转换为date类型
            String departureTimeStr = req.getParameter("departureTime");
            if (StringUtils.isEmpty(departureTimeStr)) {
                req.setAttribute("errorMsg", "departureTimeStr值不能为空");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
            Date departureTime = DateUtils.stringToDate(departureTimeStr);
            String arriveTimeStr = req.getParameter("arriveTime");
            if (StringUtils.isEmpty(arriveTimeStr)) {
                req.setAttribute("errorMsg", "arriveTimeStr值不能为空");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
            Date arriveTime = DateUtils.stringToDate(arriveTimeStr);
            String model = req.getParameter("model");
            if (StringUtils.isEmpty(model)) {
                req.setAttribute("errorMsg", "model值不能为空");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
            FlightEntity flightEntity = new FlightEntity();
            flightEntity.setId(id);
            flightEntity.setFlightId(flightId);
            flightEntity.setCompany(company);
            flightEntity.setDepartureAirport(departureAirport);
            flightEntity.setArriveAirport(arriveAirport);
            flightEntity.setDepartureTime(departureTime);
            flightEntity.setArriveTime(arriveTime);
            flightEntity.setModel(model);
            int result = flightService.updateFlight(flightEntity);
            if (result <= 0) {
                req.setAttribute("errorMsg", "删除失败");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
            //修改成功
            resp.sendRedirect("showFlight");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", "系统错误");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

}
