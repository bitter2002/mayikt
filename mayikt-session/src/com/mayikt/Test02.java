package com.mayikt;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mayikt.entity.MayiktUserEntity;

public class Test02 {
    public static void main(String[] args) {
        String jsonStr = "{\"msg\":\"ok\",\"data\":[{\"id\":1,\"userName\":\"ll\",\"userPwd\":\"4556\"},{\"id\":1,\"userName\":\"ll\",\"userPwd\":\"4556\"}],\"code\":200}";
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        Integer code = jsonObject.getInteger("code");
        String msg = jsonObject.getString("msg");
        System.out.println(code+","+msg);
        JSONArray data = jsonObject.getJSONArray("data");
        for (int i = 0; i < data.size(); i++) {
            JSONObject jsonObject1 = (JSONObject) data.get(i);
            Integer id = jsonObject1.getInteger("id");
            String userName = jsonObject1.getString("userName");
            String userPwd = jsonObject1.getString("userPwd");
            MayiktUserEntity mayiktUserEntity = new MayiktUserEntity(id, userName, userPwd);
            System.out.println(mayiktUserEntity);
        }
    }
}
