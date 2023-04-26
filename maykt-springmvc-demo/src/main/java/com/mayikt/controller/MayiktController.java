package com.mayikt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MayiktController {
    /*
     *1.@Controller作用
     *  需要在我们类上加上@Controller注解,标记该类是springmvc控制类
     *2. @RequestMapping
     * 定义我们的url映射
     * 3.@ResponseBody
     * 该接口返回我们的json数据
     * */
    @RequestMapping("/getMayikt")
    @ResponseBody
    public String getMayikt(){
        return "{code:'3200',msg:'ok'}";
    }


    // 该接口返回我们的json数据
    @RequestMapping("/getMayikt02")
    @ResponseBody
    public Map<String, Object> getMayikt02() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("code", "200");
        result.put("msg", "ok");
        //访问该接口的 返回json数据
        return result;
    }
}
