package com.mayikt.controller;

import com.mayikt.entity.MayiktUserEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MayiktUserRestfulController {
    /*
     * Restful api请求地址是一样的 根据不同的请求方法判断
     * 对User 增删查改
     * */
    //id查询--get
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/user/{id}")//同上
    public MayiktUserEntity getUser(@PathVariable("id") Integer id) {
        System.out.println("[getUser]id:" + id);
        return new MayiktUserEntity("mayikt" + id, 22);
    }

    //根据id删除数据 -- delete
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println("[deleteUser]id:" + id);
        return "OK:id" + id;
    }

    /*
     * 需要传递json数据
     * */
    //添加数据--post
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping(value = "/user")
    public String addUser(@RequestBody MayiktUserEntity mayiktUserEntity) {
        System.out.println("[addUser]mayiktUserEntity:" + mayiktUserEntity);
        return "[addUser]OK";
    }

    //修改数据--put
//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping(value = "/user")
    public String updateUser(@RequestBody MayiktUserEntity mayiktUserEntity) {
        System.out.println("[updateUser]mayiktUserEntity:" + mayiktUserEntity);
        return "[updateUser]OK";
    }
}
