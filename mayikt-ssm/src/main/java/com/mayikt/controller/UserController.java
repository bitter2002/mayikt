package com.mayikt.controller;

import com.mayikt.entity.UserEntity;
import com.mayikt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//相当于该类中定义的接口都是返回json数据
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;

    /*
     * 根据id查询数据
     * */
    @GetMapping("/getById/{id}")
    public UserEntity getById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    /*
     * 新增数据
     * */
    @PostMapping("/insertUser")
    public String insertUser(@RequestBody UserEntity userEntity) {
        return userService.insertUser(userEntity) > 0 ? "插入数据成功" : "插入数据失败!";
    }

    /*
     * 删除数据
     * */
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        return userService.deleteById(id) > 0 ? "删除数据成功" : "删除数据失败";
    }

    /*
     * 修改数据
     * */
    @PutMapping("/updateUser")
    public String updateUser(@RequestBody UserEntity userEntity) {
        return userService.updateUser(userEntity) > 0 ? "修改成功" : "修改失败";
    }
}
