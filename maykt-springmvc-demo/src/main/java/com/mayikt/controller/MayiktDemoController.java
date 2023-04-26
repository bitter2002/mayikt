package com.mayikt.controller;

import com.mayikt.entity.MayiktUserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class MayiktDemoController {
    /*
     * springmvc 五种接收参数类型
     *
     * */
    //普通参数
    @RequestMapping("/demo01")
    @ResponseBody
    public String demo01(String name, Integer age) {
        return "name:" + name + ",age:" + age;
    }

    /*
     *1.(@RequestParam("name") 地址栏传递的参数名称为name 方法的形参名称mayiktName
     *2.required 是否必须传递参数 默认为true 也就是需要传递参数  false为不需要必须传递参数
     * */
    @RequestMapping("/demo02")
    @ResponseBody
    public String demo02(@RequestParam(value = "name", required = false) String mayiktName,
                         @RequestParam(value = "age", required = false) Integer mayiktAge) {
        return "name:" + mayiktName + ",age:" + mayiktAge;
    }

    /*
     *使用对象进行参数接收
     * 地址栏中传递的参数名称与对象成员属性名称保持一致就可以
     * */
    @RequestMapping("/demo03")
    @ResponseBody
    public String demo03(MayiktUserEntity mayiktUserEntity) {
        return "name:" + mayiktUserEntity.getUserName() + ",age:" + mayiktUserEntity.getAge() + ",address" + mayiktUserEntity.getMayiktUserInfoEntity().getAddress();
    }

    /*
     *接收数组类型的参数
     * demo04?arrays=mayikt&arrays=meite
     * 请求参数名与形参属性名相同且请求参数为多个，定义数组类型形参即可接收参数
     * */
    @RequestMapping("/demo04")
    @ResponseBody
    public String demo04(String[] arrays) {
        return Arrays.toString(arrays);
    }

    @RequestMapping("/demo05")
    @ResponseBody
    public String demo05(@RequestParam List<String> arrays) {
        return Arrays.toString(arrays.toArray());
    }

    /*
     *接收json数据(以实体类形式)
     * {
    "userName":"mayikt",
    "age":22,
    "mayiktUserInfoEntity":{
        "address":"jx"
     }
        }
     *接受参数加上@RequestBody MayiktUserEntity mayiktUserEntity 标记 接受json数据
     *自动根据json数据反序列化成对象mayiktUserEntity
     * */
    @RequestMapping("/demo06")
    @ResponseBody
    public String demo06(@RequestBody MayiktUserEntity mayiktUserEntity) {
        return mayiktUserEntity.toString();
    }

    /*
     * 以map集合方式接收json数据
     * */
    @RequestMapping("/demo07")
    @ResponseBody
    public String demo07(@RequestBody Map<String, Object> paramMap) {
        return paramMap.toString();
    }

    /*
     *以json数组传递数据--List集合
     * [
     * "mayikt01",""
     * ]
     * */
    @RequestMapping("/demo08")
    @ResponseBody
    public String demo08(@RequestBody List<String> list) {
        return list.toArray().toString();
    }

    /*
     * list集合类型 对象
     * [
    {
        "userName":"lyz",
        "age":"20"
    }
    ]
     * */
    @RequestMapping("/demo09")
    @ResponseBody
    public String demo09(@RequestBody List<MayiktUserEntity> list) {
        return list.toArray().toString();
    }
}
