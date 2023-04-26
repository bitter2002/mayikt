package com.mayikt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/add")
    @ResponseBody
    public String add() {
        return "add ok";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete() {
        return "delete ok";
    }
}
