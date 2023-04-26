package com.mayikt.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Slf4j
public class MemberServiceAsync {
    @Async("taskExecutor")
    public String sms() {
        log.info(">02<");
        try {
            log.info("正在发送短信");
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        log.info(">03<");
        return "短信发送完成";
    }

}
