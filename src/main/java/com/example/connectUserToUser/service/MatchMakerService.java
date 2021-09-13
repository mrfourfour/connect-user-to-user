package com.example.connectUserToUser.service;

import com.example.connectUserToUser.domain.MatchMaker;
import com.example.connectUserToUser.domain.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchMakerService {

    private final MatchMaker matchMaker;
    private static final Logger logger = LoggerFactory.getLogger(MatchMakerService.class);

    public void operateMatchMaker(User user)
    {
        logger.info("풀에 유저 추가");
        matchMaker.applyMatchMakerList(user);

    }
}
