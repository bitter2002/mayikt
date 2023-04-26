package com.mayikt.controller;

import com.mayikt.entity.UserEntity;
import com.mayikt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController//相当于该类中定义的接口都是返回json数据
@RequestMapping("/user02")
public class UserController02 extends BaseController {
    @Autowired
    private UserService userService;

    /*
     * 根据id查询数据
     * */
    @GetMapping("/getById/{id}")
    public Map<String, Object> getById(@PathVariable("id") Integer id) {
        //验证参数
        if (id == null) {
            return setResultError("id is null");
        }
        UserEntity user = userService.getById(id);
        if (user == null) {
            return setResultError("根据该id没有查询到数据");
        }
        return setResultOk(user);
    }

//    public HashMap<String, Object> setResult(Integer code, String msg, Object data) {
//        HashMap<String, Object> result = new HashMap<String, Object>();
//        result.put("code", code);
//        result.put("msg", msg);
//        result.put("data", data);
//        return result;
//    }

    /*
     * 新增数据
     * */
    @PostMapping("/insertUser")
    public Map<String, Object> insertUser(@RequestBody UserEntity userEntity) {
        return userService.insertUser(userEntity) > 0 ? setResultSuccess("插入成功") : setResultSuccess("插入失败");
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
