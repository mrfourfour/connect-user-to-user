package com.example.connectUserToUser.service;

import com.example.connectUserToUser.domain.MatchMaker;
import com.example.connectUserToUser.domain.MatchUserPair;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

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
            log.error("error occurred while pair", e);
        }
        brokerClient.send(pair);
    }
}
