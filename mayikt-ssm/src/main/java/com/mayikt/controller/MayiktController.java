package com.mayikt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MayiktController {
    @RequestMapping("/getMayikt")
    public String getMayikt(Integer id) {
        int j = 1 / id;
        return "mayikt:" + id;
    }
}
