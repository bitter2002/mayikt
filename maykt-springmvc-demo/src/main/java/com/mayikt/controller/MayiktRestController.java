package com.mayikt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController  //标记该控制类所有接口都是返回json数据
public class MayiktRestController {
    @RequestMapping("/getMayikt03")
    public String getMayikt(){
        return "{code:'3200',msg:'ok'}";
    }

    @RequestMapping("/getMayikt04")
    public Map<String, Object> getMayikt02() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("code", "200");
        result.put("msg", "ok");
        //访问该接口的 返回json数据
        return result;
    }
}
