package com.mayikt.controller;

import java.util.HashMap;

public class BaseController {
    /*
     * 响应成功
     * */
    public HashMap<String, Object> setResultOk(Object data) {
        return setResult(200, "ok", data);
    }
    public HashMap<String, Object> setResultSuccess(String msg) {
        return setResult(200,msg, null);
    }
    /*
     * 响应失败
     * */
    public HashMap<String, Object> setResultError(String msg) {
        return setResult(500, msg, null);

    }

    public HashMap<String, Object> setResult(Integer code, String msg, Object data) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("code", 200);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }
}
