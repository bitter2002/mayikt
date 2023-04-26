package com.mayikt;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.entity.MayiktUserEntity;

import java.util.ArrayList;

public class Test01 {
    public static void main(String[] args) {
        //1.将数据对象变成json(字符串类型)
        MayiktUserEntity user1 = new MayiktUserEntity(1, "ll", "4556");
        MayiktUserEntity user2 = new MayiktUserEntity(1, "ll", "4556");
        String json1 = JSONObject.toJSONString(user1);
        System.out.println(json1);
        //2.嵌套json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",200);
        jsonObject.put("msg","ok");
        //data值,数组类型
        ArrayList<MayiktUserEntity> mayiktUserEntities = new ArrayList<>();
        mayiktUserEntities.add(user1);
        mayiktUserEntities.add(user2);
        jsonObject.put("data",mayiktUserEntities);
        System.out.println(jsonObject.toJSONString());
    }
}
