package com.mayikt.service;


import com.mayikt.async.MemberServiceAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class MemberService {
    @Autowired
    private MemberServiceAsync memberServiceAsync;

    @RequestMapping("/addMember")
    public String addMember() {
        //1.数据库插入数据
        log.info(">01<");
        //2.发送短信
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                sms();
//            }
//        }).start();
        memberServiceAsync.sms();
        return "用户注册成功";
    }

//    @Async
//    public String sms() {
//        log.info(">02<");
//        try {
//            log.info("正在发送短信");
//            Thread.sleep(3000);
//        } catch (Exception e) {
//
//        }
//        log.info(">03<");
//        return "短信发送完成";
//    }

    /*
     * 演示系统出错
     * */
    @RequestMapping("/insertUser")
    public int insertUser(int age){
        int j = 1 / age;
        return j;
    }
}
