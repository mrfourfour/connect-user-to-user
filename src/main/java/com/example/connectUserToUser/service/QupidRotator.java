package com.example.connectUserToUser.service;

import com.example.connectUserToUser.domain.MatchMaker;
import com.example.connectUserToUser.domain.MatchUserPair;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

// 틱로테이터
@Service
@RequiredArgsConstructor
@Slf4j
public class QupidRotator {

    private final MatchMaker matchMaker;
    private final BrokerClient brokerClient;

    @Scheduled(fixedDelay = 1000)
    private void scheduleMatch() {
        MatchUserPair pair = null;
        try {
            pair = matchMaker.matchUser();
        } catch (Exception e) {
            return;
        }

        brokerClient.send(pair);
        log.info("successfully send to broker");
    }

//    private final ThreadPoolTaskScheduler scheduler;
//
//    public void stopScheduler() {
//        scheduler.shutdown();
//    }
//
//    public void startScheduler() {
//        scheduler.initialize();
//        scheduler.schedule(getRunner(), getTrigger());
//    }
//
//    private Runnable getRunner() {
//        MatchUserPair pair = matchMaker.matchUser();
//        return () -> {
//            try {
//                brokerClient.send(pair);
//            } catch (Exception e) {
//                log.error("error occurred while pair", e);
//            }
//        };
//    }
//
//    private Trigger getTrigger() {
//        // 작업 주기 설정
//        return new PeriodicTrigger(1, TimeUnit.SECONDS);
//    }

}