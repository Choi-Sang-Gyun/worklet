package com.project2.worklet.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

    // 매일 오전 7시에 실행
    @Scheduled(cron = "0 23 15 * * *")
    public void runEveryMorningAt7() {
        System.out.println("🌅 아침 7시 실행됨! " + java.time.LocalDateTime.now());

    }
}
