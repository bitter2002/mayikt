package com.mayikt.service;

import com.mayikt.entity.MayiktEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class IndexController {
    @Value("${mayikt.name}")
    private String name;

    @Value("${mayikt.age}")
    private String age;

    @RequestMapping("/getNameAndAge")
    public String getNameAndAge() {
        log.info("name + \",\" + age");
        try {

        }catch (Exception e){
            log.error("");
        }
        return name + "," + age;
    }

    @Autowired
    private MayiktEntity mayiktEntity;

    /*
     *
     * */
    @RequestMapping("/get")
    public String get() {
        return mayiktEntity.toString();

    }

}
