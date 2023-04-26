package com.mayikt.service;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MayiktExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<Object, Object> exceptionHandler() {
        Map<Object, Object> map = new HashMap<>();
        map.put("error", "500");
        map.put("msg", "系统出现错误~");
        return map;
    }

}
