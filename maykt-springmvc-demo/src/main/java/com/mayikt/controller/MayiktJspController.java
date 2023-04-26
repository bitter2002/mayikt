package com.mayikt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 访问mayiktJsp转发到jsp页面
 * 该方法返回json数据  @ResponseBody
 * 根据返回值跳转到具体的渲染界面
 * */
@Controller
public class MayiktJspController {
    @RequestMapping("/mayiktJsp")
    public String mayiktJsp() {
        return "mayikt";
    }
}