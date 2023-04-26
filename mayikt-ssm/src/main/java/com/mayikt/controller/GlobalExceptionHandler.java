package com.mayikt.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Objects;

//全局捕获异常
@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public HashMap<String, Object> handleException(Exception exception) {
        System.out.println("e:" + exception);
        return setResultError("系统发生错误");
    }
}
