package com.example.connectUserToUser.domain;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class MatchMaker {
    private static final Logger logger = LoggerFactory.getLogger(MatchMaker.class);
    // 쓰레드 세이프하지않서 우선순위큐를 사용하지 않음
    private Queue<User> users;
    private Random random;

    public MatchMaker() {
        this.users = new PriorityBlockingQueue<>();
        this.random = new Random();
    }

    private boolean vaildUser(User user) {
        return users.contains(user);
    }

    public User applyMatchMakerList(User user) {
        if (vaildUser(user)) {
            throw new IllegalArgumentException("이미 대기열에 있습니다.");
        } else {
            users.add(user);
            return user;
        }

    }

    public MatchUserPair matchUser() {
        if (users.size() <= 1) {
            logger.info("대기인원이 1명 이하...");
            throw new IllegalStateException("...");
        }
        return startMatch();
    }

    private MatchUserPair startMatch() {
        User left = users.poll();
        User right = users.poll();
        String roomId = UUID.randomUUID().toString();
        return new MatchUserPair(left, right, roomId);
    }

//    private void startMatch() {
//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//
//                Collections.shuffle(Collections.singletonList(users));
//                if (users.size() % 2 == 0) {
//                    logger.info("2명 매치 성공");
//                    users.remove(users.peek());
//                    users.remove(users.peek());
//                    timer.cancel();
//                }
//
//            }
//        };
//        timer.schedule(timerTask, 0, 1000);
//
//    }
}




/*
 * 유저 id를 컨트롤러에서 받고
 * 서비스 단에서는 매치메이커 도메인으로 가서
 * 도메인의 유저 풀에서 유저어 id를 넣고
 * 2명 딱되면 쥬풀에서 해당 유저 id를 지워준다.
 * */
