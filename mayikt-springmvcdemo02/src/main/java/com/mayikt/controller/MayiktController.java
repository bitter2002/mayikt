package com.mayikt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MayiktController {
   @RequestMapping("/hello")
    @ResponseBody
    public String getMayikt() {
        return "ok";
    }
}
