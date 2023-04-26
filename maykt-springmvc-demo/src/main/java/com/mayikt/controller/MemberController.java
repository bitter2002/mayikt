package com.mayikt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
    /*
     * method = RequestMethod.POST 设定该接口支持的类型为post类型
     * */
    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    @ResponseBody
    public String addMemberPost(Integer id, String name) {
        System.out.println("id:" + id);
        System.out.println("name:" + name);
        return "ok";
    }

    @RequestMapping(value = "/httpRequestDemo01", method = RequestMethod.GET)
    @ResponseBody
    public String httpRequestDemo01(Integer id, String name, HttpServletRequest httpServletRequest) {
        System.out.println("id:" + id);
        System.out.println("name:" + name);
        String reqId = httpServletRequest.getParameter("id");
        String reqName = httpServletRequest.getParameter("name");
        System.out.println("id:"+reqId);
        System.out.println("name:"+reqName);
        return "ok";
    }
}
