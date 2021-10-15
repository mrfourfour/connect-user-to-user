package com.example.connectUserToUser.domain;

import com.example.connectUserToUser.service.QupidRotator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

    // 현재 유저가 풀에 있는지 검증
    private boolean vaildUser(User user) {
        return users.contains(user);
    }

    // 리스트에 추가하는 로직
    public User applyMatchMakerList(User user) {
        if (vaildUser(user)) {
            throw new IllegalArgumentException("Exits User.");
        } else {
            users.add(user);
            return user;
        }
    }

    public MatchUserPair matchUser() {
        if (users.size() <= 1) {
            logger.info("waiting 1 user or less");
            throw new IllegalArgumentException();
        }

        return startMatch();
    }


    private MatchUserPair startMatch() {
        User left = users.poll();
        User right = users.poll();
        String roomId = UUID.randomUUID().toString();
        return new MatchUserPair(left, right, roomId);
    }


}


//매치메이커는 말그대로 두 유저를 임의로 선택하는 것에 집중해야 합니다.
//
//선택하고 뽑아내는 것은 매치메이커의 책임일까요? => 제일 궁금한것 뭘 어떻게 해야할까?
//도메인 레이어는 바깥 레이어의 어떤 의존성도 주입하지 않아야 합니다.

/*
 * 유저 id를 컨트롤러에서 받고
 * 서비스 단에서는 매치메이커 도메인으로 가서
 * 도메인의 유저 풀에서 유저어 id를 넣고
 * 2명 딱되면 쥬풀에서 해당 유저 id를 지워준다.
 * */

