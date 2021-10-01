package com.example.connectUserToUser.domain;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;

public class MatchMaker {
    private static final Logger logger = LoggerFactory.getLogger(MatchMaker.class);
    private static final PriorityQueue<String> users = new PriorityQueue<>();

    // 리스트에 추가하는 로직
    public void applyMatchMakerList(User user) {
        if (!vaildUser(user)) {
            users.add(user.getUserId());
            matchUser();
        } else {
            throw new IllegalArgumentException();
        }
    }

    // 현재 유저가 풀에 있는지 검증
    private boolean vaildUser(User user) {
        return users.contains(user);
    }

    // 매칭 유저
    private void matchUser() {
        if(checkPollSize()){
            throw new IllegalArgumentException();
        }
        else{
            startMatch();
        }
    }

    // 매칭 시작 2명 일단 뽑아 -> 어떻게 임의로 뽑아?
    private void startMatch() {
        String user1 = users.peek();
        String user2 = users.peek();

    }
    // 풀 사이즈 검증
    private boolean checkPollSize() {
        if (users.size() <= 1) {
            logger.info("대기인원이 1명 이하...");
            return true;
        } else {
            return false;
        }

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

