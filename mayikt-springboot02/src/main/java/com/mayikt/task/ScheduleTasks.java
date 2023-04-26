package com.mayikt.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduleTasks {
    /*
    * 每隔3秒执行taskService()
    * */
//    @Scheduled(fixedRate = 3000)
    /*
    * 隔两秒
    * */
//    @Scheduled(cron = "1/2 * * * * ? ")
    public void taskService(){
        log.info("<<定时任务执行>>"+System.currentTimeMillis());
    }
}
