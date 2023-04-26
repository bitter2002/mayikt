package com.mayikt;

import com.alibaba.fastjson.JSONObject;

public class Test03 {
    public static void main(String[] args) {
        String jsonStr = "{\"msg\":\"ok\",\"data\":[{\"id\":1,\"userName\":\"ll\",\"userPwd\":\"4556\"},{\"id\":1,\"userName\":\"ll\",\"userPwd\":\"4556\"}],\"code\":200}";
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        Result result = jsonObject.parseObject(jsonStr, Result.class);
        //java序列化技术,json变成对象
        System.out.println(result);
    }
}
